package club.maddm.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义身份验证失败处理程序
 * @author King
 * @version 1.0
 * @date 2019/12/23 21:10
 */
@Slf4j
public class KingAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request
            , HttpServletResponse response
            , AuthenticationException exception) throws IOException, ServletException {
        if (log.isDebugEnabled()) {
            log.debug("king >>>>>>>>>>>>>>>>>>>>>>>>>> 登陆失败请重试！");
        }
        log.error(exception.getLocalizedMessage());//本地化信息
        log.error(exception.getMessage());//信息
        log.error(exception.getStackTrace().toString());//调用栈

        response.setStatus(HttpStatus.UNAUTHORIZED.value());//设置401状态
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("loginError");
        writer.flush();
        writer.close();
        return;
    }
}
