package club.maddm.common.mapper;

import club.maddm.common.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author king
 * @since 2019-12-18
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<UserRole> selectRoleByIds(@Param("ids") List<String> ids);
}
