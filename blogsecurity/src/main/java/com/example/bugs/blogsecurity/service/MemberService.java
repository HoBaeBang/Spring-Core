package com.example.bugs.blogsecurity.service;

import com.example.bugs.blogsecurity.Model.MemberDto;
import com.example.bugs.blogsecurity.Model.MemberInfo;
import com.example.bugs.blogsecurity.Model.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {      // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return memberRepository.findByEmail(email)
                .orElseThrow(
                        ()-> new UsernameNotFoundException((email))
                );
    }   //원래 반환타입은 userDetails인데 그것을 상속받는 memberinfo로 반환타입 지정



    public Long save(MemberDto memberDto) {  //회원정보를 DTO에 받아서 회원 정보를 저장
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        memberDto.setPassword(encoder.encode(memberDto.getPassword()));

        return memberRepository.save(MemberInfo.builder()
                .email(memberDto.getEmail())
                .auth(memberDto.getAuth())
                .password(memberDto.getPassword()).build()).getId();
    }
}
