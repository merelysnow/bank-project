package com.github.merelysnow.bankproject.user.service;

import com.github.merelysnow.bankproject.repository.UserRepository;
import com.github.merelysnow.bankproject.user.data.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        saveUser(user);
    }

    public User findUserById(int id) throws Exception {
        final User user = this.userRepository.findUserById(id);
        if (user == null) throw new Exception("Nenhum usuario foi encontrado com esse id.");

        return user;
    }

    public void saveUser(@NonNull User user) {
        this.userRepository.save(user);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }
}
