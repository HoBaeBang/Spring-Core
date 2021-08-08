package com.example.aop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User {
    private String id;
    private String pw;
    private String email;

}
