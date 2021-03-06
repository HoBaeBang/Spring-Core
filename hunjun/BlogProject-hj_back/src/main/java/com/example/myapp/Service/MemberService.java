package com.example.myapp.Service;


import com.example.myapp.Domain.Entity.MemberEntity;
import com.example.myapp.Domain.Repository.MemberRepository;
import com.example.myapp.Domain.Role;
import com.example.myapp.Dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException  {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByUsername(userName);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userName)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getUsername(), userEntity.getPassword(),authorities);
    }
}
