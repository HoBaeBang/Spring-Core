package com.example.bugs.blogsecurity.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberInfo,Long> {
    Optional<MemberInfo> findByEmail(String email);
}
