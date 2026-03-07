package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.UserDto;
import com.cwa.gedApp.entity.User;

public interface UserService {

    User createUser  (User user);
    User getUserById(Long idUser);
    void deleteUserbyId (Long idUser);
    User updateUser(Long id , UserDto userDto);
}
