package club.maddm.config;

import club.maddm.common.entity.enums.ExceptionEnum;
import club.maddm.common.exception.KingException;
import club.maddm.common.result.ExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 通用异常处理
 */
@ControllerAdvice//拦截所有controller,参数annotations:配置拦截其他注解
@Slf4j
public class CommonExceptionHandler {
    /**
     * 方法的返回值就是返给页面的
     */
    @ExceptionHandler({KingException.class})//配置拦截的异常
    public ResponseEntity<ExceptionResult> handleException(KingException e){
        //返回状态码,和我们自己异常处理信息类
        return ResponseEntity
                .status(e.getExceptionEnum().getCod())//状态码
                .body(new ExceptionResult(e.getExceptionEnum()));//返回体

    }

    /**
     * 如果通用异常拦不住，使用这个拦截
     */
    @ExceptionHandler({Exception.class})//配置拦截的异常
    public ResponseEntity<ExceptionResult> handleAllException(Exception e){
        //打印调用轨迹
        log.error(e.getMessage());
        e.printStackTrace();

        //返回状态码,和我们自己异常处理信息类
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())//状态码
                .body(new ExceptionResult(ExceptionEnum.DEFOULT_ERROR));//返回体

    }
}