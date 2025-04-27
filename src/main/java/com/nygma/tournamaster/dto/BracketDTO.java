package com.nygma.tournamaster.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class BracketDTO {
    private UUID id;
    private UUID categoryId;
    private LocalDateTime generatedAt;
    private String status;
    private String seedingMethod;
    private Integer roundsCount;
    private Set<MatchDTO> matches;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeedingMethod() {
        return seedingMethod;
    }

    public void setSeedingMethod(String seedingMethod) {
        this.seedingMethod = seedingMethod;
    }

    public Integer getRoundsCount() {
        return roundsCount;
    }

    public void setRoundsCount(Integer roundsCount) {
        this.roundsCount = roundsCount;
    }

    public Set<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(Set<MatchDTO> matches) {
        this.matches = matches;
    }
}
