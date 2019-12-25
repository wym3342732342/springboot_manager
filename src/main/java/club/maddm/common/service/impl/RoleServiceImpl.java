package club.maddm.common.service.impl;

import club.maddm.common.entity.Role;
import club.maddm.common.mapper.RoleMapper;
import club.maddm.common.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
