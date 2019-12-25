package club.maddm.common.entity;

import club.maddm.common.entity.vo.UserInfo;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Data
@Accessors(chain = true)
@TableName("common_user")
public class User implements UserDetails {

private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
//    @NotNull(message = "密码不能为空")
    private String passWord;

    /**
     * 盐值
     */
    private String saltValue;

    /**
     * 真实姓名
     */
    @NotNull(message = "真实姓名不能为空")
    private String realName;

    /**
     * 住址
     */
    @NotNull(message = "住址不能为空")
    private String address;

    /**
     * 身份
     */
    private String identity;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 逻辑删除
     */
    @TableLogic
    private String flag;

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

    /**
     * 身份id集合
     */
    @TableField(exist = false)
    private List<String> roleIds;

    /**
     * 角色名称集合
     */
    @TableField(exist = false)
    private List<String> roleNames;

    /**
     * 存放用户信息
     */
    @TableField(exist = false)
    private UserInfo userInfo;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isEmpty(roleNames)) {
            return null;
        }
        //返回角色信息
        return roleNames.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return Integer.parseInt(flag) == 0;//逻辑为删除就是生效
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Integer.parseInt(flag) == 0;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof User)) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(userName, user.userName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userName)
                .toHashCode();
    }

    /**
     * 返回用户
     * @return 用户信息，没有头像
     */
    public UserInfo getUserInfo() {
        if (userInfo == null) {
            this.userInfo = new UserInfo(id,userName,realName,address,identity,"");
        }
        return this.userInfo;
    }
}
