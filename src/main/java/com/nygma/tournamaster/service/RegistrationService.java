package com.nygma.tournamaster.service;

import com.nygma.tournamaster.model.Registration;
import com.nygma.tournamaster.model.Tournament;
import com.nygma.tournamaster.repository.RegistrationRepository;
import com.nygma.tournamaster.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(UUID id) {
        Optional<Registration> registration = registrationRepository.findById(id);

        return registration.orElse(null);
    }
}
