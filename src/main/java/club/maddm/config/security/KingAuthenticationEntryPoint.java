package club.maddm.config.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 自定义的认证入口点
 * @author King
 * @version 1.0
 * @date 2019/12/23 20:28
 */
@Slf4j
public class KingAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2) throws IOException, ServletException {
        if (log.isDebugEnabled()) {
            log.debug("king >>>>>>>>>>>>>>>>>>>>>>>>>> 预先认证的入口点称为。拒绝访问");
        }

        response.setStatus(403);//设置403状态
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("toLogin");
        writer.flush();
        writer.close();
        return;
    }

}
