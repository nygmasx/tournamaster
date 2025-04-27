package com.nygma.tournamaster.controller;

import com.nygma.tournamaster.dto.TournamentDTO;
import com.nygma.tournamaster.service.TournamentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Tournament Api")
@RestController
@RequestMapping("/tournaments")
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @Operation(summary = "Finds tournaments", description = "Finds tournaments", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tournaments",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TournamentDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Tournaments were not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))}),
    })
    @GetMapping()
    public ResponseEntity<List<TournamentDTO>> getTournaments() {
        return ResponseEntity.ok(tournamentService.getTournaments());
    }

    @Operation(summary = "Finds a tournament", description = "Finds a tournament by his Id", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tournament",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TournamentDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Tournament was not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))}),
    })
    @GetMapping("/{id}")
    public ResponseEntity<TournamentDTO> getTournament(@PathVariable UUID id) {
        return ResponseEntity.ok(tournamentService.getTournamentById(id));
    }

    @Operation(summary = "Creates a tournament", description = "Creates a new tournament", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tournament created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TournamentDTO.class))}),
    })
    @PostMapping
    public ResponseEntity<TournamentDTO> createTournament(@RequestBody TournamentDTO tournamentDTO) {
        return new ResponseEntity<>(tournamentService.createTournament(tournamentDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Updates a tournament", description = "Updates an existing tournament", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tournament updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TournamentDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Tournament was not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))}),
    })
    @PutMapping("/{id}")
    public ResponseEntity<TournamentDTO> updateTournament(@PathVariable UUID id, @RequestBody TournamentDTO tournamentDTO) {
        return ResponseEntity.ok(tournamentService.updateTournament(id, tournamentDTO));
    }

    @Operation(summary = "Deletes a tournament", description = "Deletes an existing tournament", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tournament deleted"),
            @ApiResponse(responseCode = "404", description = "Tournament was not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))}),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable UUID id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }
}
