package club.maddm.common.service;

import club.maddm.common.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据roleid查询角色信息
     * @param id
     * @return
     */
    public Role queryRoleInfoById(String id);
}
