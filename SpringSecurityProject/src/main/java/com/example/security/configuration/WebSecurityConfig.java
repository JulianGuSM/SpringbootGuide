package com.example.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author : Julian
 * @date : 2019/2/20 10:33
 * 使用@EnableWebSecurity注释WebSecurityConfig类来开启SpringSecurity的web security支持，
 * 并且提供SpringMVC集成
 * 继承 WebSecurityConfigurerAdapter类，重写几个他的方法来设置一些特殊的web security的配置
 *
 * configure方法定义了哪个URL需要安全验证哪些不用，特别地，“/”，“/home”路径配置为不需要任何验证
 * 其他所有路径必须被验证
 *
 * 当一个用户成功地登陆，他们将会重定向到之前请求身份验证的页面。LoginPage()指定了一个自定义的/login页面
 * 并且每个人都可以访问
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/home").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    /**
     * userDetailsService()方法，它使用单个用户设置了一个内存中的用户存储，这个用户用户名为root，密码为root
     * 角色是USER
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User
                            .withUsername("root")
                            .password(passwordEncoder.encode("root"))
                            .roles("USER")
                            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
