package com.nygma.tournamaster.security;

import com.nygma.tournamaster.RoleEnum;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.nygma.tournamaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findOneByEmail(email)
                .map(this::createSecurityUser)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
    }

    private User createSecurityUser(com.nygma.tournamaster.model.User user) {
        List<SimpleGrantedAuthority> grantedRoles = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name())
        );

        return new User(user.getEmail(), user.getPassword(), grantedRoles);
    }
}
