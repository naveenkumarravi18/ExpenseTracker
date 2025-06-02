package com.example1.demo.repository;



import com.example1.demo.Entity.Users;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    User findByUsername(String username);
}

