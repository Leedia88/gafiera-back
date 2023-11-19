package com.aicap.springbootwebapi.service;

import com.aicap.springbootwebapi.dao.UserDao;
import com.aicap.springbootwebapi.entity.Event;
import com.aicap.springbootwebapi.entity.User;
import com.aicap.springbootwebapi.entity.dto.LoginDto;
import com.aicap.springbootwebapi.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    User getUser(String email);

    User getLoggedUser(LoginDto loginDto);

    User saveUser(UserDto userDto);

    List<User> getAllUsers();

    User updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    List<Event> getEnrolledEvents(Long user_id);


}
