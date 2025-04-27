package com.nygma.tournamaster.mapper;

import com.nygma.tournamaster.dto.PlayerDTO;
import com.nygma.tournamaster.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(source = "user.id", target = "userId")
    PlayerDTO toDto(Player player);

    @Mapping(target = "user", ignore = true)
    Player toEntity(PlayerDTO playerDTO);
}
