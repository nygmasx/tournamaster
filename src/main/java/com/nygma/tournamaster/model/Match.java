package com.nygma.tournamaster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bracket_id", nullable = false)
    private Bracket bracket;

    @NotNull
    @Column(name = "round_number", nullable = false)
    private Integer roundNumber;

    @NotNull
    @Column(name = "match_number", nullable = false)
    private Integer matchNumber;

    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id")
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    @Column(name = "scheduled_time")
    private LocalDateTime scheduledTime;

    @Column(name = "actual_start_time")
    private LocalDateTime actualStartTime;

    @Column(name = "actual_end_time")
    private LocalDateTime actualEndTime;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status = "SCHEDULED"; // SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED

    @Column(name = "win_method")
    private String winMethod; // SUBMISSION, POINTS, DQ, etc.

    @Column(name = "points_player1")
    private Integer pointsPlayer1;

    @Column(name = "points_player2")
    private Integer pointsPlayer2;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "next_match_id")
    private Match nextMatch;

    @Column(name = "next_match_position")
    private Integer nextMatchPosition; // 1 or 2

    public UUID getId() {
        return id;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public void setBracket(Bracket bracket) {
        this.bracket = bracket;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(Integer matchNumber) {
        this.matchNumber = matchNumber;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalDateTime getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(LocalDateTime actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public LocalDateTime getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(LocalDateTime actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWinMethod() {
        return winMethod;
    }

    public void setWinMethod(String winMethod) {
        this.winMethod = winMethod;
    }

    public Integer getPointsPlayer1() {
        return pointsPlayer1;
    }

    public void setPointsPlayer1(Integer pointsPlayer1) {
        this.pointsPlayer1 = pointsPlayer1;
    }

    public Integer getPointsPlayer2() {
        return pointsPlayer2;
    }

    public void setPointsPlayer2(Integer pointsPlayer2) {
        this.pointsPlayer2 = pointsPlayer2;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Match getNextMatch() {
        return nextMatch;
    }

    public void setNextMatch(Match nextMatch) {
        this.nextMatch = nextMatch;
    }

    public Integer getNextMatchPosition() {
        return nextMatchPosition;
    }

    public void setNextMatchPosition(Integer nextMatchPosition) {
        this.nextMatchPosition = nextMatchPosition;
    }
}
