package com.example.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder")  //bean으로 등록이 된다. 8번 줄에 있는 마크가 그의미이다.
public class Base64Encoder implements IEncoder {

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
