package cn.mldn.microcloud.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    public void configGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        //可以设置内存指定的登录的账号、密码、角色
        //.passwordEncoder(new MyPasswordEncoder())，这样，页面提交时候，密码以明文的方式进行匹配。
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("mldnjava").password("hello").roles("USER").and()
                .withUser("admin").password("hello").roles("USER", "ADMIN");
        //不加.passwordEncoder(new MyPasswordEncoder()),就不是以明文的方式进行匹配，会报错
//        auth.inMemoryAuthentication().withUser("mldnjava").password("hello")
//                .roles("USER").and().withUser("admin").password("hello")
//                .roles("USER", "ADMIN");
    }
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
