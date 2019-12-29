package club.maddm.common.entity.excepyionEntity;

import club.maddm.common.result.ExceptionResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 1xx：指示信息–表示请求已接收，继续处理
 * 2xx：成功–表示请求已被成功接收、理解、接受
 * 3xx：重定向–要完成请求必须进行更进一步的操作
 * 4xx：客户端错误–请求有语法错误或请求无法实现
 * 5xx：服务器端错误–服务器未能实现合法的请求
 *
 * 常见状态代码、状态描述、说明：
 * 200 OK //客户端请求成功
 * 400 Bad Request //客户端请求有语法错误，不能被服务器所理解
 * 401 Unauthorized //请求未经授权，这个状态代码必须和WWW-Authenticate报头域一起使用
 * 403 Forbidden //服务器收到请求，但是拒绝提供服务
 * 404 Not Found //请求资源不存在，eg：输入了错误的URL
 * 500 Internal Server Error //服务器发生不可预期的错误
 * 503 Server Unavailable //服务器当前不能处理客户端的请求，一段时间后可能恢复正常
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum implements ExceptionResult.ExceptionStandard {
    UNIFIED_PROCESSING(500,"当前系统正忙！"),//500
    FILE_IS_TOO_LARGE(400,"单个文件大小超过10M"),//400
    FILE_NOT_NULL(400,"文件不能为空"),
    FILE_UPLOAD_ERROR(500,"文件上传失败"),
    DEFOULT_ERROR(500,"系统正忙！"),
    PASSWORD_NOT_NULL(400,"密码不能为空！"),
    MENU_UPID_EROR(400,"上级设置错误！"),
    ROLE_INFO_NOT_FIND(404,"角色信息没有找到"),
    ;
    private int cod;
    private String msg;
}