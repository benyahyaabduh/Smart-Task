package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.UserDto;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.mapper.UserMapper;
import com.cwa.gedApp.repository.UserDao;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    private final UserMapper userMapper;

    public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        if (userDao.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        return userDao.save(user);
    }

    @Override
    public User getUserById(Long idUser) {
        return userDao.findById(idUser).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUserbyId(Long id) {
       if (!userDao.existsById(id)) {
           throw new RuntimeException("User not found");
       }
       userDao.deleteById(id);

    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        User user = userDao.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));

        userMapper.updateUserFromDto(userDto,user);
        return userDao.save(user);
    }


}
