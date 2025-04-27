package com.nygma.tournamaster.repository;

import com.nygma.tournamaster.model.Bracket;
import com.nygma.tournamaster.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
}
