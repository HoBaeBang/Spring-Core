package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

 // 스프링에서 Bean은 하나만 있으면 바로 매칭하지만
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public void setiEncoder (IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
