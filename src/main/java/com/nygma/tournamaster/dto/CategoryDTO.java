package com.nygma.tournamaster.dto;

import com.nygma.tournamaster.BeltRankingEnum;

import java.util.UUID;

public class CategoryDTO {
    private UUID id;
    private String name;
    private String gender;
    private Double minWeight;
    private Double maxWeight;
    private BeltRankingEnum beltLevel;
    private Integer minAge;
    private Integer maxAge;

    private UUID tournamentId;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Double minWeight) {
        this.minWeight = minWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BeltRankingEnum getBeltLevel() {
        return beltLevel;
    }

    public void setBeltLevel(BeltRankingEnum beltLevel) {
        this.beltLevel = beltLevel;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public UUID getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(UUID tournamentId) {
        this.tournamentId = tournamentId;
    }
}
