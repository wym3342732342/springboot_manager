package club.maddm.config;


import club.maddm.config.security.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsUtils;



/**
 * @author King
 * @version 1.0
 * @date 2019/12/22 13:12
 */
@Slf4j
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置加密方式
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()/*.configurationSource()*/.and().csrf().disable()//关闭cors,csrf不关闭登陆有问题【不安全】
            .httpBasic().disable()//关闭http基本基本身份验证
            .exceptionHandling()
//                .accessDeniedHandler(new MyAccessDeniedHandler())
                .authenticationEntryPoint(new KingAuthenticationEntryPoint())
                .and()
            .formLogin()
                .permitAll()
                .failureHandler(new KingAuthenticationFailureHandler())
                .successHandler(new KingAuthenticationSuccessHandler())
                .and()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/common/auth").permitAll()
//                .and()
            .authorizeRequests()//授权请求
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//允许所有跨域前一个请求
//                .antMatchers("/common/menu/query").permitAll()//允许访问
//                .antMatchers("/common/**").hasAuthority("系统管理员")//有admin权限
                .antMatchers("/common/**").authenticated()
                .anyRequest().permitAll()//允许其他接口
//                .anyRequest().authenticated()//都必须按规则认证
                .and()
            .sessionManagement().sessionFixation().none()
        ;
    }
}
