package io.ashlin.restfulwebservices.service;

import io.ashlin.restfulwebservices.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserByID(Long userId);
    List<User> getAllUsers();
    User updateUser(User user );
    void deleteUser(Long userId);
}
