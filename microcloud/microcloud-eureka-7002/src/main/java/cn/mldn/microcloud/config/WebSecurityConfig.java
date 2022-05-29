package cn.mldn.microcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 默认情况下，当Spring Security位于类路径上时，它将要求在每次向应用程序发送请求时都发送一个有效的CSRF令牌。
        // Eureka客户机通常不会拥有一个有效的跨站点请求伪造令牌(CSRF)，您需要禁用/ Eureka /**端点的这个请求
        http.csrf().ignoringAntMatchers("/eureka/**");
        // 表示所有的访问都必须进行认证处理后才可以正常进行
        http.httpBasic().and().authorizeRequests().anyRequest()
                .fullyAuthenticated();
        // 所有的Rest服务一定要设置为无状态，以提升操作性能
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
