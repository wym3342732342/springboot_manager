package club.maddm.common.mapper;

import club.maddm.common.entity.Role;
import club.maddm.common.entity.antd.vo.AntdValVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据roleids查询对应菜单【去重】
     * @param ids
     * @return
     */
    List<String> selectMenuIdsByRoleIds(@Param("ids") List<String> ids);

    /**
     * 根据roleids查询对应菜单【去重】
     * @param ids
     * @return
     */
    List<AntdValVO> selectMenusByRoleIds(@Param("ids") List<String> ids);
}
