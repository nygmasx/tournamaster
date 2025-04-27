package com.nygma.tournamaster.mapper;

import com.nygma.tournamaster.dto.UserDTO;
import com.nygma.tournamaster.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "role", target = "role")
    UserDTO toDto(User user);

    @Mapping(source = "role", target = "role")
    User toEntity(UserDTO userDTO);
}
