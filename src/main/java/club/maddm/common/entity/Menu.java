package club.maddm.common.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("common_menu")
public class Menu implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 路由
     */
    @NotNull(message = "key不能为空！")
    @TableField("`key`")
    private String key;

    /**
     * 菜单名称
     */
    @NotNull(message = "菜单名称不能为空！")
    private String title;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 是否有孩子 默认为否，对其新增孩子时改变
     */
    private String havingChildren;

    /**
     * 是否可点击
     */
    private String havingClick;

    /**
     * 权限key
     */
    private String authKey;

    /**
     * 上级id
     */
    @NotNull(message = "上级节点不能为空！")
    private String upId;

    /**
     * 逻辑删除
     */
    @TableLogic
    private String flag;

    /**
     * 归属id
     */
    private String ascription;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
