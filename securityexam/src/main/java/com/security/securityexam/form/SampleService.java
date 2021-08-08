package com.security.securityexam.form;

import com.security.securityexam.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    public void dashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //어선트케이션에 컨텍스트홀더->컨텍스트->어선트케이션이있음
        Object principal = authentication.getPrincipal();   //어선트케이션 안에 프린시펄을 가지고옴 프린시펄은 임의의 타입(사실상 유저디테일 타입)이라 오브젝트로 해줌
        Collection<? extends GrantedAuthority> authorities= authentication.getAuthorities();//사용자가 가지고있는권한을 나타내는것이 어서리티라는것임
        Object credential = authentication.getCredentials();            //credential은 인증을 했는지를 볼수있는거임
        boolean authenticated = authentication.isAuthenticated();
    }
}
