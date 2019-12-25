package club.maddm.common.service;

import club.maddm.common.entity.User;
import club.maddm.common.entity.vo.UserInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
public interface IUserService extends IService<User> {

    /**
     * 注册或更改用户
     * @param user
     */
    void registr(User user);

    /**
     * 根据账户密码查询用户
     * @param username
     * @param password
     * @return
     */
    User queryUser(String username, String password);

    /**
     * 分页查询用户信息
     * @param page
     * @param name
     * @return
     */
    IPage<User> queryUserByPage(Page<User> page, String name);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User queryUserById(String id);
}
