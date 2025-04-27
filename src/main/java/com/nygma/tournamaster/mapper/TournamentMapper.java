package com.nygma.tournamaster.mapper;

import com.nygma.tournamaster.dto.TournamentDTO;
import com.nygma.tournamaster.model.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CategoryMapper.class})
public interface TournamentMapper {

    @Mapping(source = "owner", target = "owner")
    @Mapping(source = "categories", target = "categories")
    TournamentDTO toDto(Tournament tournament);

    List<TournamentDTO> toDtoList(List<Tournament> tournaments);

    @Mapping(source = "owner", target = "owner")
    @Mapping(source = "categories", target = "categories")
    Tournament toEntity(TournamentDTO tournamentDTO);
}
