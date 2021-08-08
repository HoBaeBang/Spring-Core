package com.security.securityexam.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {
    //UserDetailsService는 DB에 있는 정보를 가지고 인증을 할때 사용하는 인터페이스
    //UserDetailsService를 만족시키는 조건은 username에 해당하는 user정보를 가지고 와가지고 userDetail타입으로 리턴을 해주어야함

   @Autowired AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);
        if(account ==null){
            throw new UsernameNotFoundException(username);
        }
        return User.builder()           //스프링 시큐리티에서 제공하는 유저클래스를 이용해서 간단하게 유저 딭테일즈로 리턴을 할 수 있다.
                .username(account.getUserName())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

    public Account createNew(Account account) {
        account.encodePassword(passwordEncoder);
        return this.accountRepository.save(account);
    }
}
