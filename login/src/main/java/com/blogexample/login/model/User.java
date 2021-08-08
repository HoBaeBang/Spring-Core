package com.blogexample.login.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNumber;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Builder
    public User(UserRequestDto userRequestDto) {
        this.id = userRequestDto.getId();
        this.password = userRequestDto.getPassword();
        this.name = userRequestDto.getName();
        this.email = userRequestDto.getEmail();
    }
}
