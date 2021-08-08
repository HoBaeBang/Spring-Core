package com.blogexample.login.controller;

import com.blogexample.login.model.User;
import com.blogexample.login.model.UserRequestDto;
import com.blogexample.login.model.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor    //final 변수로 생성된 변수릉 자동으로 생성합니다.
@RestController             //json으로 주고 받음을 선언합니다.
public class LoginController {

    private final UserInfoRepository userInfoRepository;
    private Object ResponseEntity;

    @PostMapping("/user/login")
    public void UserLogin(@RequestBody UserRequestDto userDto) {
        String userEmail = userDto.getEmail();
        userInfoRepository.findByEmail(userEmail);
        //return
    }

    @PostMapping
    public String abc() {
        Error error = new Error();
        String av = error.toString();
        return av;
    }

    /*@PostMapping("/register")
    public ResponseEntity<T> registerPost(@RequestBody MemberDto memberDto){
        System.out.println("여기는 post register");
        System.out.println(memberDto);
        MemberDto member = new MemberDto();
        if(!memberService.checkUserInfo(memberDto.username)){    //중복 = true, 중복x = false
            member.setUsername(memberDto.username);
            member.setPassword(memberDto.password);
            memberService.joinUser(memberDto);
            System.out.println(memberDto);

            return ResponseEntity ; // String일 때, return "/check";
        }else{
            member.setUsername(null);
            member.setPassword(null);
            System.out.println("아이디 중복!");
            return ResponseEntity;
        }*/

    /*@PostMapping("/user/register")
    public ResponseEntity<Message> resosterPost(@RequestBody User userIn){
        User user = new User();
        user.setId("111");
        Message message = new Message();
        if(user.getName() == userIn.getName()){
            message.setStatus(StatusEnum.OK);
            message.setMessage("성공");
            message.setData(userIn);

            return ResponseEntity<>(message);
        }
    }*/


    @PostMapping("/user/id")
    public Message userpost(@RequestBody User userIn) {
        Message message = new Message();
        message.setData(userIn);
        message.setMessage("성공");

        return message;

    }

}
