package club.maddm.common.entity.excepyionEntity;

import club.maddm.common.result.ExceptionResult;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author King
 * @version 1.0
 * @date 2019/12/28 14:00
 */
@Data
public class CustomMessageExceptionEnum implements ExceptionResult.ExceptionStandard {
    private int cod;
    private String msg;

    /**
     * 私有构造
     */
    private CustomMessageExceptionEnum() {}

    private CustomMessageExceptionEnum(int cod, String msg) {
        this.cod = cod;
        this.msg = msg;
    }

    /**
     * 客户端语法错误的处理异常
     * @param msg
     * @return
     */
    public static CustomMessageExceptionEnum badRequest(String msg) {
        return new CustomMessageExceptionEnum(HttpStatus.BAD_REQUEST.value(), msg);
    }

    /**
     * 服务端异常
     * @param msg
     * @return
     */
    public static CustomMessageExceptionEnum internalServerError(String msg) {
        return new CustomMessageExceptionEnum(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    /**
     * 没有找到
     * @param msg
     * @return
     */
    public static CustomMessageExceptionEnum notFound(String msg) {
        return new CustomMessageExceptionEnum(HttpStatus.NOT_FOUND.value(), msg);
    }

    /**
     * 未经授权的访问
     * @param msg
     * @return
     */
    public static CustomMessageExceptionEnum unauthorized(String msg) {
        return new CustomMessageExceptionEnum(HttpStatus.UNAUTHORIZED.value(), msg);
    }
}
