package club.maddm.common.controller;


import club.maddm.common.entity.Role;
import club.maddm.common.entity.enums.ExceptionEnum;
import club.maddm.common.exception.KingException;
import club.maddm.common.service.IRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Controller
@RequestMapping("/common/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    /**
     * 查询所有
     * @return
     */
    @GetMapping("all")
    public ResponseEntity<List<Role>> queryAllRole() {
        return ResponseEntity.ok(roleService.list());//查询所有
    }

    /**
     * 分页查询角色
     * @param page 分页信息
     * @param roleName 角色名
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<IPage<Role>> queryRoleByPage(Page<Role> page, String roleName) {
        return ResponseEntity
                .ok(roleService.page(page,
                        Wrappers.<Role>lambdaQuery().like(Role::getRoleName, roleName != null ? roleName : "_")));
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Role> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(roleService.getById(id));
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        roleService.removeById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 保存
     * @param role
     * @return
     */
    @PostMapping("save")
    public ResponseEntity<Void> save(Role role) {
        if (StringUtils.isNotEmpty(role.getId())) {
            roleService.updateById(role);//根据id更新
        }else {
            roleService.save(role);//保存
        }
        return ResponseEntity.ok().build();
    }
}

