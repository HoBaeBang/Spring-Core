package com.example.myapp.Controller;

import com.example.myapp.Dto.MemberDto;
import com.example.myapp.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemberController {
    private MemberService memberService;

    //@RequestMapping("/error")
    //public String handleError(){
    //    return "/index.html";
    //}

    //@Override
    // public String getErrorPath(){
    //   return "/error";
    // }

    //메인 페이지  get
    //@GetMapping("/")
    //public String index(){
    //   return "/index";
    //}

    //로그인 페이지 get
    @GetMapping("/login")
    public String Displogin() {
        return "hello, log in";
    }

    // 로그인 페이지 post -> 로그인 후 메인페이지로 이동
    @PostMapping("/api/auth/login")
    public String execLogin() {
        return "redirect:/";
    }

    // 회원가입 get
    @GetMapping("/register")
    public String DispRegister() {
        return "hello, register";
    }

    // 회원가입 post
    @PostMapping("/register")
    public String exeRegister(@RequestBody MemberDto memberDto) {
        System.out.println("여기까지는 괜춘");
        memberService.joinUser(memberDto);
        return "redirect:/login";
    }

    /*@PostMapping("/register")
    public String Register(MemberDto memberDto){
        memberService.joinUser(memberDto);
        return "/register/";

    }*/


    @GetMapping("/ip")
    public String hello() {
        //요청을 보낸 클라이언트의 IP주소를 반환환
        return "hello, 현재 서버 시간은" + new Date() + "입니다. \n";
    }
}
