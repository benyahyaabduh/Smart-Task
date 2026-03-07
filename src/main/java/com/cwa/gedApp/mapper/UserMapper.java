package com.cwa.gedApp.mapper;

import com.cwa.gedApp.dtos.UserDto;
import com.cwa.gedApp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity (UserDto userDto);

    UserDto toDto (User user);

    void updateUserFromDto(UserDto dto, @MappingTarget User user);


}
