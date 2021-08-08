package com.blogexample.login.service;

import com.blogexample.login.model.User;
import com.blogexample.login.model.UserInfoRepository;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserInfoRepository userInfoRepository;

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userInfoRepository.findAll().forEach(e -> users.add(e));
        return users;
    }

    public Optional<User> findById;

}
