package com.nygma.tournamaster.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistrationDTO {
    private UUID id;
    private UUID playerId;
    private UUID categoryId;
    private LocalDateTime registrationDate;
    private Boolean weightConfirmed;
    private Double actualWeight;
    private String status;
    private PlayerDTO player;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getWeightConfirmed() {
        return weightConfirmed;
    }

    public void setWeightConfirmed(Boolean weightConfirmed) {
        this.weightConfirmed = weightConfirmed;
    }

    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }
}
