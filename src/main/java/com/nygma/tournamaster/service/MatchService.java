package com.nygma.tournamaster.service;

import com.nygma.tournamaster.model.Match;
import com.nygma.tournamaster.model.Tournament;
import com.nygma.tournamaster.repository.MatchRepository;
import com.nygma.tournamaster.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(UUID id) {
        Optional<Match> match = matchRepository.findById(id);

        return match.orElse(null);
    }
}
