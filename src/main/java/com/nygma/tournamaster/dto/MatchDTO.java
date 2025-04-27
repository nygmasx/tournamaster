package com.nygma.tournamaster.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class MatchDTO {
    private UUID id;
    private UUID bracketId;
    private Integer roundNumber;
    private Integer matchNumber;
    private UUID player1Id;
    private UUID player2Id;
    private UUID winnerId;
    private LocalDateTime scheduledTime;
    private LocalDateTime actualStartTime;
    private LocalDateTime actualEndTime;
    private String status;
    private String winMethod;
    private Integer pointsPlayer1;
    private Integer pointsPlayer2;
    private String notes;
    private UUID nextMatchId;
    private Integer nextMatchPosition;

    // Informations sur les joueurs (sans références circulaires)
    private PlayerDTO player1;
    private PlayerDTO player2;
    private PlayerDTO winner;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBracketId() {
        return bracketId;
    }

    public void setBracketId(UUID bracketId) {
        this.bracketId = bracketId;
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

    public UUID getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(UUID player1Id) {
        this.player1Id = player1Id;
    }

    public UUID getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(UUID player2Id) {
        this.player2Id = player2Id;
    }

    public UUID getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(UUID winnerId) {
        this.winnerId = winnerId;
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

    public UUID getNextMatchId() {
        return nextMatchId;
    }

    public void setNextMatchId(UUID nextMatchId) {
        this.nextMatchId = nextMatchId;
    }

    public Integer getNextMatchPosition() {
        return nextMatchPosition;
    }

    public void setNextMatchPosition(Integer nextMatchPosition) {
        this.nextMatchPosition = nextMatchPosition;
    }

    public PlayerDTO getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerDTO player1) {
        this.player1 = player1;
    }

    public PlayerDTO getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerDTO player2) {
        this.player2 = player2;
    }

    public PlayerDTO getWinner() {
        return winner;
    }

    public void setWinner(PlayerDTO winner) {
        this.winner = winner;
    }
}
