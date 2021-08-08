package com.example.bugs.blogsecurity.controller;

import com.example.bugs.blogsecurity.Model.MemberDto;
import com.example.bugs.blogsecurity.Model.MemberInfo;
import com.example.bugs.blogsecurity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/user")
    public String signup(MemberDto memberDto) { // 회원 추가
        memberService.save(memberDto);
        System.out.println(memberDto);
        return "redirect:/userlogin";
    }

    @GetMapping(value = "/logout")      //로그아웃 하는데 config파일에서 설정해둔거는 csrf있어야해서 없이 로그아웃 할수 있도록 get맵핑
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/userlogin";
    }

}
