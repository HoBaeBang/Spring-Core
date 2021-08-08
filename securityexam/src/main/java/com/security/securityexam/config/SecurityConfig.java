package com.security.securityexam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {      //이렇게 하면 스프링 웹 설정 파일이 만들어 진것임


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/","/info","/account/**").permitAll()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();

    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hobae").password("{noop}123").roles("USER").and()    //{noop}은 스프링에서 사용하는 기본 패스워드 인코더이다.
                .withUser("admin").password("{noop}!@#").roles("ADMIN");        //{}안에 암호화하는 방법 인코딩 하는방법 을 넣으면된다.
    }//DB를사용해서 USER정보를 넣고 인증을 하는 방법을 알아볼것이다.*/
}
