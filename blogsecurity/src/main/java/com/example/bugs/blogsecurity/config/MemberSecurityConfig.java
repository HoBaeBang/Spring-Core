package com.example.bugs.blogsecurity.config;

import com.example.bugs.blogsecurity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MemberSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

    @Override
    public void configure(WebSecurity web) throws Exception {       //인증을 무시할 경로 설정
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**","/html/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {  //http관련 인증 설정
        http
                .authorizeRequests()
                    .antMatchers("/login","/singup","/user").permitAll()  // 누구나 접근 허용
                    .antMatchers("/").hasRole("USER")
                    .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()   //나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근

                .and()
                    .formLogin()    //로그인에 대한 설정
                        .loginPage("/userlogin")//로그인 페이지 링크
                        .permitAll()//
                        .defaultSuccessUrl("/") //로그인 성공 후 리다이렉트 주소
                .and()
                    .logout()   //로그아웃에 관한 설정을 의미
                        .logoutSuccessUrl("/userlogin") // 로그아웃 성공시 리다이렉트 주소
                        .invalidateHttpSession(true) // 세션 날리기
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {      //로그인 할때 필요한 정보를 가져오는곳
        auth.userDetailsService(memberService)
                // 해당 서비스(memberService)에서는 UserDetailsService를 implements해서
                // loadUserByUsername() 구현필요
                .passwordEncoder(new BCryptPasswordEncoder());     }
}
