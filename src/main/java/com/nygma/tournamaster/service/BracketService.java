package com.nygma.tournamaster.service;

import com.nygma.tournamaster.model.Bracket;
import com.nygma.tournamaster.model.Tournament;
import com.nygma.tournamaster.repository.BracketRepository;
import com.nygma.tournamaster.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BracketService {

    @Autowired
    private BracketRepository bracketRepository;

    public List<Bracket> getBrackets() {
        return bracketRepository.findAll();
    }

    public Bracket getBracketById(UUID id) {
        Optional<Bracket> bracket = bracketRepository.findById(id);

        return bracket.orElse(null);
    }
}
