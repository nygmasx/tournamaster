package com.nygma.tournamaster.repository;

import com.nygma.tournamaster.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, UUID> {

    @Query("SELECT t FROM Tournament t LEFT JOIN FETCH t.categories c LEFT JOIN FETCH t.owner")
    List<Tournament> findAll();

    @Query("SELECT t FROM Tournament t LEFT JOIN FETCH t.categories c LEFT JOIN FETCH t.owner WHERE t.id = :id")
    Optional<Tournament> findById(@Param("id") UUID id);
}
