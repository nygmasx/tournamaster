package com.nygma.tournamaster.repository;

import com.nygma.tournamaster.model.Bracket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BracketRepository extends JpaRepository<Bracket, UUID> {
}
