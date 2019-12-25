package club.maddm.common.service.impl;

import club.maddm.common.entity.UserRole;
import club.maddm.common.mapper.UserRoleMapper;
import club.maddm.common.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author king
 * @since 2019-12-18
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
