package com.nygma.tournamaster.repository;

import com.nygma.tournamaster.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findOneByEmail(String email);

    List<User> findAllByEmailIn(List<String> emails);
}
