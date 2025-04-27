package com.nygma.tournamaster.mapper;

import com.nygma.tournamaster.dto.CategoryDTO;
import com.nygma.tournamaster.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "tournament.id", target = "tournamentId")
    @Mapping(source = "beltLevel", target = "beltLevel")
    CategoryDTO toDto(Category category);

    Set<CategoryDTO> toDtoSet(Set<Category> categories);

    @Mapping(target = "tournament", ignore = true)
    @Mapping(target = "registrations", ignore = true)
    @Mapping(target = "bracket", ignore = true)
    @Mapping(source = "beltLevel", target = "beltLevel")
    Category toEntity(CategoryDTO categoryDTO);
}
