package com.cwa.gedApp.controller;

import com.cwa.gedApp.dtos.UserDto;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.mapper.UserMapper;
import com.cwa.gedApp.repository.UserDao;
import com.cwa.gedApp.services.UserService;
import com.cwa.gedApp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/User")
public class UserController {

    private final UserMapper userMapper;

    private final UserService userService;
    private final UserDao userDao;

    public UserController(UserService userService, UserMapper userMapper, UserDao userDao) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.userDao = userDao;
    }


    @PostMapping("/AddUser")
    User createUser (@RequestBody UserDto userDto){

        User user = userMapper.toEntity(userDto);
        return userService.createUser(user);
    }

    @GetMapping("/FindUser/{id}")
    User getUserById (@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/DeleteUser/{id}")
    void deleteUserById (@PathVariable Long id){
        userService.deleteUserbyId(id);

    }


    @PutMapping("/UpdateUser/{id}")
    User updateUser (@PathVariable Long id,@RequestBody UserDto userDto){
        return userService.updateUser( id,userDto);
    }


}
