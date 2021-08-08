package com.blogexample.login.config;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {

    private String remoteIp;
    private String sessionId;
    private LocalDateTime loginTime;
}
