package club.maddm.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 身份验证成功处理程序
 * @author King
 * @version 1.0
 * @date 2019/12/23 21:28
 */
@Slf4j
public class KingAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {
        if (log.isDebugEnabled()) {
            log.debug("king >>>>>>>>>>>>>>>>>>>>>>>>>> 登陆失败请重试！");
        }

        response.setStatus(HttpStatus.OK.value());//设置200状态
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("loginSuccess");
        writer.flush();
        writer.close();
        return;
    }
}
