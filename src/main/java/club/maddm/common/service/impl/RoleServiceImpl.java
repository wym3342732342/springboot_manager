package club.maddm.common.service.impl;

import club.maddm.common.entity.Role;
import club.maddm.common.entity.RoleMenu;
import club.maddm.common.entity.antd.vo.AntdValVO;
import club.maddm.common.entity.excepyionEntity.ExceptionEnum;
import club.maddm.common.exception.KingException;
import club.maddm.common.mapper.RoleMapper;
import club.maddm.common.service.IRoleMenuService;
import club.maddm.common.service.IRoleService;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private IRoleMenuService roleMenuService;

    /**
     * 根据roleid查询角色信息
     * @param id
     * @return
     */
    public Role queryRoleInfoById(String id) {
        Role role = roleMapper.selectById(id);
        if (role == null) {
            throw new KingException(ExceptionEnum.ROLE_INFO_NOT_FIND);
        }
        List<AntdValVO> menus = roleMapper.selectMenusByRoleIds(Collections.singletonList(id));
        role.setMenus(menus);
        return role;
    }

    /**
     * 保存或更新
     * @param role
     * @return
     */
    public boolean saveOrUpdate(Role role) {
        if (StringUtils.isNotEmpty(role.getId())) {
            updateById(role);//根据id更新
            //更新的话 删除之前的菜单
            roleMenuService.remove(Wrappers
                    .<RoleMenu>lambdaUpdate().eq(RoleMenu::getRoleId,role.getId()));
        }else {
            save(role);//保存
        }
        //添加菜单
        if (CollectionUtils.isNotEmpty(role.getMenuIds())) {
            List<RoleMenu> menus = role.getMenuIds().stream().map(id -> {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(id);
                roleMenu.setRoleId(role.getId());
                return roleMenu;
            }).collect(Collectors.toList());
            //批量插入
            roleMenuService.saveBatch(menus, menus.size());
        }
        return true;
    }
}
