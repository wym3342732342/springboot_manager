package club.maddm.common.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * @author King
 * @version 1.0
 * @date 2019/12/15 19:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 住址
     */
    private String address;

    /**
     * 身份
     */
    private String identity;
    /**
     * 用户头像
     */
    private String imgUrl;
}
