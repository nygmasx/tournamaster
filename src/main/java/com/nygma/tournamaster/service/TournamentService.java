package com.nygma.tournamaster.service;

import com.nygma.tournamaster.dto.TournamentDTO;
import com.nygma.tournamaster.mapper.TournamentMapper;
import com.nygma.tournamaster.model.Tournament;
import com.nygma.tournamaster.repository.TournamentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
    }

    @Transactional(readOnly = true)
    public List<TournamentDTO> getTournaments() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return tournamentMapper.toDtoList(tournaments);
    }

    @Transactional(readOnly = true)
    public TournamentDTO getTournamentById(UUID id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournament not found with id: " + id));
        return tournamentMapper.toDto(tournament);
    }

    @Transactional
    public TournamentDTO createTournament(TournamentDTO tournamentDTO) {
        Tournament tournament = tournamentMapper.toEntity(tournamentDTO);
        tournament = tournamentRepository.save(tournament);
        return tournamentMapper.toDto(tournament);
    }

    @Transactional
    public TournamentDTO updateTournament(UUID id, TournamentDTO tournamentDTO) {
        Tournament existingTournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournament not found with id: " + id));

        existingTournament.setName(tournamentDTO.getName());
        existingTournament.setCity(tournamentDTO.getCity());
        existingTournament.setState(tournamentDTO.getState());
        existingTournament.setCountry(tournamentDTO.getCountry());
        existingTournament.setDate(tournamentDTO.getDate());

        existingTournament = tournamentRepository.save(existingTournament);
        return tournamentMapper.toDto(existingTournament);
    }

    @Transactional
    public void deleteTournament(UUID id) {
        if (!tournamentRepository.existsById(id)) {
            throw new EntityNotFoundException("Tournament not found with id: " + id);
        }
        tournamentRepository.deleteById(id);
    }
}
