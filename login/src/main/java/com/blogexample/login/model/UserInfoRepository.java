package com.blogexample.login.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<User, Long> {

    public List<User> findByEmail(String email);

    public List<User> findByName(String name);

    public List<User> findByPassword(String password);

    public List<User> findById(String id);

    public List<User> findAll();
}
