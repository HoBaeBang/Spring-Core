package com.example.myapp.Dto;


import com.example.myapp.Domain.Entity.MemberEntity;
import lombok.*;

import java.lang.reflect.Member;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
