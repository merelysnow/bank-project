package com.github.merelysnow.bankproject.repository;

import com.github.merelysnow.bankproject.user.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(int id);
}
