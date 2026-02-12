package com.cwa.gedApp.repository;

import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    List<User> findByUserName(String username);

    boolean existsByUserName(String userName);

    boolean existByEmail(String email);


}
