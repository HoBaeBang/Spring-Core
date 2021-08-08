package com.example.myapp.Domain.Repository;

import com.example.myapp.Domain.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByUsername(String userName);
}
