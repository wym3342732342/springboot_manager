package club.maddm.config;

import club.maddm.common.entity.excepyionEntity.CustomMessageExceptionEnum;
import club.maddm.common.entity.excepyionEntity.ExceptionEnum;
import club.maddm.common.exception.KingException;
import club.maddm.common.result.ExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 所有验证框架异常捕获处理
     * @return
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Object validationExceptionHandler(Exception exception) {
        BindingResult bindResult = null;
        if (exception instanceof BindException) {
            bindResult = ((BindException) exception).getBindingResult();
        } else if (exception instanceof MethodArgumentNotValidException) {
            bindResult = ((MethodArgumentNotValidException) exception).getBindingResult();
        }
        String msg;
        if (bindResult != null && bindResult.hasErrors()) {
            msg = bindResult.getAllErrors().get(0).getDefaultMessage();
            if (msg.contains("NumberFormatException")) {
                msg = "参数类型错误！";
            }
        }else {
            msg = "系统正忙！";
        }
        ExceptionResult exceptionResult
                = new ExceptionResult(CustomMessageExceptionEnum.badRequest(msg));
        return ResponseEntity.status(exceptionResult.getStatus()).body(exceptionResult);
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