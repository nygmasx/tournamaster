package com.nygma.tournamaster.service;

import com.nygma.tournamaster.model.Player;
import com.nygma.tournamaster.model.Tournament;
import com.nygma.tournamaster.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(UUID id) {
        Optional<Player> player = playerRepository.findById(id);

        return player.orElse(null);
    }
}
