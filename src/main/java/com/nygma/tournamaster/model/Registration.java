package com.nygma.tournamaster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @NotNull
    @Column(name = "weight_confirmed", nullable = false)
    private Boolean weightConfirmed = false;

    @Column(name = "actual_weight")
    private Double actualWeight;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status = "PENDING"; // PENDING, CONFIRMED, CANCELLED

    public UUID getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
