package club.maddm.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author king
 * @since 2019-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("common_user_role")
@ApiModel(value="UserRole对象", description="用户角色表")
public class UserRole implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "用户表id")
    private String userId;

    @ApiModelProperty(value = "角色表id")
    private String roleId;

    @ApiModelProperty(value = "用于存放角色名，用于分页查询user表用！")
    @TableField(exist = false)
    private String roleName;

}
