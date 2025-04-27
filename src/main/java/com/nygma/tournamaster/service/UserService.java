package com.nygma.tournamaster.service;

import com.nygma.tournamaster.model.User;
import com.nygma.tournamaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }
}
