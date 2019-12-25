package club.maddm.common.controller;


import club.maddm.common.entity.User;
import club.maddm.common.entity.vo.UserInfo;
import club.maddm.common.service.IUserService;
import club.maddm.utils.UserUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Api(value = "用户相关的Controller")
@Controller
@RequestMapping("/common/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册或更改用户
     * @param user
     * @return
     */
    @PostMapping("registr")
    public ResponseEntity<Void> registr(@Valid User user) {
        userService.registr(user);
        return ResponseEntity.ok().build();
    }

    /**
     * 查询当前登陆用户
     * @return
     */
    @ApiOperation(value = "查询当前登陆用户")
    @GetMapping("queryInfo")
    public ResponseEntity<UserInfo> queryUser() {
        return ResponseEntity.ok(UserUtil.getUserDetail());
    }

    /**
     * 根据条件分页查询用户信息
     * @param page
     * @param userName
     * @return
     */
    @GetMapping("infoPage")
    public ResponseEntity<IPage<User>> queryUserByPage(Page<User> page, String userName) {
        return ResponseEntity.ok(userService.queryUserByPage(page, userName));
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("query/{id}")
    public ResponseEntity<User> queryUserById(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.queryUserById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        userService.removeById(id);
        return ResponseEntity.ok().build();
    }
}

