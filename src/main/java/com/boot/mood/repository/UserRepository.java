package com.boot.mood.repository;

import com.boot.mood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String Email);
    User findByUid(String uid);

}
