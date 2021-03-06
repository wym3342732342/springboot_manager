package club.maddm.common.service.impl;

import club.maddm.common.entity.Menu;
import club.maddm.common.entity.User;
import club.maddm.common.entity.UserRole;
import club.maddm.common.entity.excepyionEntity.ExceptionEnum;
import club.maddm.common.entity.enums.MenuEnum;
import club.maddm.common.entity.vo.ReactMenuNode;
import club.maddm.common.entity.vo.UserInfo;
import club.maddm.common.exception.KingException;
import club.maddm.common.mapper.MenuMapper;
import club.maddm.common.mapper.RoleMapper;
import club.maddm.common.service.IMenuService;
import club.maddm.common.service.IUserRoleService;
import club.maddm.common.service.IUserService;
import club.maddm.utils.ReactMenuNodeUtils;
import club.maddm.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserService userService;

    /**
     * 查询菜单
     * @return
     */
    @Override
    public List<ReactMenuNode> queryMenunodes() {
        //获取用户的角色
        UserInfo userDetail = UserUtil.getUserDetail();
        List<UserRole> roles
                = userRoleService.list(Wrappers.<UserRole>lambdaQuery()
                .eq(UserRole::getUserId, userDetail.getId()));

        LambdaQueryWrapper<Menu> wrapper = null;

        User user = userService.queryUserById(userDetail.getId());

        if (! StringUtils.equals("1", user.getPreset())) {//不是预设类型
            List<String> menuIds =
                    roleMapper.selectMenuIdsByRoleIds(roles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
            wrapper = Wrappers.<Menu>lambdaQuery().in(Menu::getId,menuIds);//根据id集合查询
        }

        List<Menu> menus = menuMapper.selectList(wrapper);

        //如果不是预设类型

        //拼装成树
        Map<String, List<ReactMenuNode>> map = ReactMenuNodeUtils.classification(menus);
        List<ReactMenuNode> menuNodeList = ReactMenuNodeUtils.assemble(map, "0");
        return menuNodeList;
    }

    /**
     * 保存菜单
     * @param menu
     */
    @Override
    public void saveMenu(@Valid Menu menu) {
        //更改父级节点
        if (!StringUtils.equals(menu.getUpId(), "0")) {

            //上级id不为空
            Menu fatherMenu = new Menu();
            fatherMenu.setHavingChildren(MenuEnum.HAVE_KIDS.value);//设置为有子节点

            fatherMenu.setCreatedTime(new Date());
            fatherMenu.setUpdatedTime(new Date());

            fatherMenu.setCreatedBy("king");
            fatherMenu.setUpdatedBy("king");

            //更改没有子孩子的父节点更改为有子节点
            UpdateWrapper<Menu> wrapper = new UpdateWrapper<>();
            wrapper.eq("id", menu.getUpId());
            wrapper.eq("having_children", MenuEnum.NOT_HAVE_KIDS.value);
            menuMapper.update(fatherMenu, wrapper);
        }

        menu.setCreatedTime(new Date());
        menu.setUpdatedTime(new Date());

        menu.setCreatedBy("king");
        menu.setUpdatedBy("king");

        //保存
        save(menu);
    }

    /**
     * 根据id查询菜单
     * @param menuId
     * @return
     */
    @Override
    public ReactMenuNode queryById(String menuId) {
        Menu menu = menuMapper.selectById(menuId);
        ReactMenuNode reactMenuNode = new ReactMenuNode();

        BeanUtils.copyProperties(menu, reactMenuNode);

        return reactMenuNode;
    }

    /**
     * 新增或保存菜单
     * @param reactMenuNode
     */
    @Override
    public void save(ReactMenuNode reactMenuNode) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(reactMenuNode,menu);

        if (StringUtils.isBlank(menu.getId())) {//没有id，新建菜单
            save(menu);//保存
        }else{
            List<Menu> menus = menuMapper.selectList(null);
            //查找属于自己的子节点
            //拼装成树
            Map<String, List<ReactMenuNode>> map = ReactMenuNodeUtils.classification(menus);
            List<ReactMenuNode> menuNodeList = ReactMenuNodeUtils.assemble(map, menu.getId());

            LinkedList<String> ids = new LinkedList<>();

            selectChildIds(ids,menuNodeList);

            if (ids.contains(menu.getUpId()) || StringUtils.equals(menu.getId(), menu.getUpId())) {
                throw new KingException(ExceptionEnum.MENU_UPID_EROR);
            }

            updateById(menu);//更新
        }
    }

    /**
     * 根据树形节点查找自己和自己孩子的ids
     * @param ids
     * @param menuNodeList
     */
    private void selectChildIds(LinkedList<String> ids, List<ReactMenuNode> menuNodeList) {
        if (CollectionUtils.isNotEmpty(menuNodeList)) {
            menuNodeList.forEach(item->{
                ids.add(item.getId());
                selectChildIds(ids, item.getChildren());//递归查id
            });
        }
    }
}
