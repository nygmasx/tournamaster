package com.nygma.tournamaster.config;

import com.nygma.tournamaster.RoleEnum;
import com.nygma.tournamaster.model.User;
import com.nygma.tournamaster.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Profile("dev")
public class DataConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataConfig(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setEmail("user@tournamaster.fr");
            user1.setRole(RoleEnum.ROLE_USER);
            user1.setPassword(passwordEncoder.encode("xxx"));

            User user2 = new User();
            user2.setEmail("admin@tournamaster.fr");
            user2.setRole(RoleEnum.ROLE_ADMIN);
            user2.setPassword(passwordEncoder.encode("xxx"));

            userRepository.saveAll(List.of(user1, user2));
        }
    }
}
