package com.blogexample.login.config;

import org.springframework.security.authentication.AuthenticationDetailsSource;

import java.net.http.HttpRequest;

public class CustomAuthDetails implements AuthenticationDetailsSource<HttpRequest, RequestInfo> {

    @Override
    public RequestInfo buildDetails(HttpRequest request) {
        return null;
    }
}
