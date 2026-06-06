package com.cwa.gedApp.mapper;

import com.cwa.gedApp.dtos.TaskDto;
import com.cwa.gedApp.dtos.UserDto;
import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity (TaskDto taskDto);

    TaskDto toDto (Task task);
}
