package com.nygma.tournamaster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "brackets")
public class Bracket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status = "DRAFT"; // DRAFT, PUBLISHED, IN_PROGRESS, COMPLETED

    @Column(name = "seeding_method")
    private String seedingMethod; // RANDOM, RANK_BASED, etc.

    @Column(name = "rounds_count")
    private Integer roundsCount;

    @OneToMany(mappedBy = "bracket", cascade = CascadeType.ALL)
    private Set<Match> matches;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }
}
