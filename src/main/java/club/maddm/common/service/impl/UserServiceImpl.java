package club.maddm.common.service.impl;

import club.maddm.common.entity.User;
import club.maddm.common.entity.UserRole;
import club.maddm.common.entity.excepyionEntity.ExceptionEnum;
import club.maddm.common.exception.KingException;
import club.maddm.common.mapper.UserMapper;
import club.maddm.common.mapper.UserRoleMapper;
import club.maddm.common.service.IUserRoleService;
import club.maddm.common.service.IUserService;
import club.maddm.utils.CodecUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Service
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User> implements IUserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Autowired
    private IUserRoleService userRoleService;


    /**
     * Spring Scurity必须实现此方法才能正常从数据库中获取用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库查询
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        HashMap<String, List<String>> userRoleMap = getRoleIdsHashMap(Collections.singletonList(user.getId()));

        //设置所有角色
        user.setRoleNames(userRoleMap.get(user.getId()));

        return user;
    }



    /**
     * 注册或更改用户
     * @param user
     */
    @Override
    @Transactional
    public void registr(User user) {

        //更新的设置更新时间
        user.setUpdatedBy("king");
        user.setUpdatedTime(new Date());
        if (StringUtils.isBlank(user.getId())) {
            //新增用户
            if (StringUtils.isBlank(user.getPassword())) {
                throw new KingException(ExceptionEnum.PASSWORD_NOT_NULL);
            }

            //加盐加密
            user.setPassWord(CodecUtils.bCryptHashpw(user.getPassword()));

            user.setId(null);
            user.setCreatedBy("king");
            user.setCreatedTime(new Date());
            userMapper.insert(user);
        }else {
            user.setPassWord(null);
            userMapper.updateById(user);
            //更新user先删除之前的角色
            userRoleService.remove(Wrappers
                    .<UserRole>lambdaUpdate().eq(UserRole::getUserId, user.getId()));
        }

        //配置角色信息
        if (CollectionUtils.isNotEmpty(user.getRoleIds())) {
            List<UserRole> userRoles = user.getRoleIds().stream().map(roleId -> {
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);//配置角色id
                userRole.setUserId(user.getId());//配置用户id
                return userRole;
            }).collect(Collectors.toList());
            userRoleService.saveBatch(userRoles, userRoles.size());//批量插入
        }
    }

    /**
     * 根据账户密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User queryUser(String username, String password) {

        User user = userMapper.selectOne(
                Wrappers.<User>lambdaQuery().eq(User::getUsername, username));

        //判断user是否为空
        if (user == null) {
            return null;
        }
        //和数据库的秘密比较
        if (CodecUtils.bCryptCheckpw(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public IPage<User> queryUserByPage(Page<User> page, String name) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery();

        //构建查询条件
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like(User::getUsername, name);
        }

        IPage<User> userIPage
                = userMapper.selectPage(page,queryWrapper);

        //拿出所有用户id
        List<String> userIds = userIPage.getRecords().stream().map(User::getId).collect(Collectors.toList());

        //联查中间表和角色表查处觉色姓名
        HashMap<String, List<String>> userRoleMap = getRoleIdsHashMap(userIds);

        //设置角色
        userIPage.getRecords().forEach(user -> {
            user.setRoleNames(userRoleMap.get(user.getId()));
        });

        return userIPage;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public User queryUserById(String id) {
        User user = userMapper.selectById(id);
        List<UserRole> userRoles
                = userRoleService.list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        //设置角色id
        user.setRoleIds(
                userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList())
        );
        //返回用户
        return user;
    }



    /**
     * 根据用户ids查找出队形的角色名集合，并分组
     * @param strings 用户ids
     * @return
     */
    private HashMap<String, List<String>> getRoleIdsHashMap(List<String> strings) {
        //联查中间表和角色表查处觉色姓名
        List<UserRole> userRoles = userRoleMapper.selectRoleByIds(strings);

        //根据用户id分组
        HashMap<String, List<String>> userRoleMap = new HashMap<>();
        //分组
        userRoles.forEach(userRole -> {
            if (userRoleMap.containsKey(userRole.getUserId())) {
                userRoleMap.get(userRole.getUserId()).add(userRole.getRoleName());
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(userRole.getRoleName());
                userRoleMap.put(userRole.getUserId(), list);
            }
        });
        return userRoleMap;
    }
}
