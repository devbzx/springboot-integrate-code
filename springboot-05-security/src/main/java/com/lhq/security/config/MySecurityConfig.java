package com.lhq.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求功能
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能
        http.formLogin().usernameParameter("username").passwordParameter("password").
                loginPage("/userlogin");
        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("rem");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("lisi")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("wangwu")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2","VIP3");
    }
}
