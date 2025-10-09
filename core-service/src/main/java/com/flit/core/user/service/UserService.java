package com.flit.core.user.service;

import com.flit.core.user.entity.User;
import com.flit.core.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String id, String email) {
        User user = new User();

        user.setId(id);
        user.setEmail(email);

        return userRepository.save(user);
    }
}
