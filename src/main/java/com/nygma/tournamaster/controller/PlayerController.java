package com.nygma.tournamaster.controller;

import com.nygma.tournamaster.model.Player;
import com.nygma.tournamaster.model.Tournament;
import com.nygma.tournamaster.service.PlayerService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Players Api")
@RestController
@RequestMapping("/players")
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Operation(summary = "Finds players", description = "Finds players", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "players",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class))}),
            @ApiResponse(responseCode = "404", description = "Players were not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))}),
    })
    @GetMapping()
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @Operation(summary = "Finds a player", description = "Finds a player by his Id", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class))}),
            @ApiResponse(responseCode = "404", description = "Player was not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))}),
    })

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable UUID id) {
        return playerService.getPlayerById(id);
    }
}
