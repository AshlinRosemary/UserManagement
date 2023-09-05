package io.ashlin.restfulwebservices.service;

import io.ashlin.restfulwebservices.dto.UserDto;
import io.ashlin.restfulwebservices.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto getUserByID(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user );
    void deleteUser(Long userId);
}
