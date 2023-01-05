package com.example.Exam.Portal.Application.repositories;

import com.example.Exam.Portal.Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

   public User findByUsername(String username);


}
