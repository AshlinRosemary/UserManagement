package io.ashlin.restfulwebservices.service.impl;

import io.ashlin.restfulwebservices.dto.UserDto;
import io.ashlin.restfulwebservices.entity.User;
import io.ashlin.restfulwebservices.mapper.UserMapper;
import io.ashlin.restfulwebservices.repository.UserRepository;
import io.ashlin.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto){
        //DTO to JPA
        User user= UserMapper.maptoUser(userDto);
        User savedUser= userRepository.save(user);

        //JPA to DTO
        UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public User getUserByID(Long userId) {
        Optional<User> optionalUser =userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser= userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
