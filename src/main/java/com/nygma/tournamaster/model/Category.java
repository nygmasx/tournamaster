package com.nygma.tournamaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nygma.tournamaster.BeltRankingEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotNull
    @Column(name = "min_weight", nullable = false)
    private Double minWeight;

    @NotNull
    @Column(name = "max_weight", nullable = false)
    private Double maxWeight;

    @NotNull
    @Column(name = "belt_level", nullable = false)
    private BeltRankingEnum beltLevel;

    @NotNull
    @Column(name = "min_age", nullable = false)
    private Integer minAge;

    @NotNull
    @Column(name = "max_age", nullable = false)
    private Integer maxAge;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    @JsonIgnoreProperties("categories")
    private Tournament tournament;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Registration> registrations;

    @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
    private Bracket bracket;

    public UUID getId() {
        return id;
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

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public void setBracket(Bracket bracket) {
        this.bracket = bracket;
    }
}
