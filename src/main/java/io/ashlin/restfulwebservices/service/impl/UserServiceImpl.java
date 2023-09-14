package io.ashlin.restfulwebservices.service.impl;

import io.ashlin.restfulwebservices.dto.UserDto;
import io.ashlin.restfulwebservices.entity.User;
import io.ashlin.restfulwebservices.mapper.AutoUserMapper;
import io.ashlin.restfulwebservices.mapper.UserMapper;
import io.ashlin.restfulwebservices.repository.UserRepository;
import io.ashlin.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto){
        //Convert UserDto to User JPA entity
        //DTO to JPA
       // User user= UserMapper.maptoUser(userDto);
       // User user= modelMapper.map(userDto,User.class);
        User user= AutoUserMapper.Mapper.mapToUser(userDto);
        User savedUser= userRepository.save(user);

        //JPA to DTO
        //UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);
        //UserDto savedUserDto=modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto=AutoUserMapper.Mapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserByID(Long userId) {
        Optional<User> optionalUser =userRepository.findById(userId);
        User user = optionalUser.get();
        //return UserMapper.mapToUserDto(user);
       // return modelMapper.map(user,UserDto.class);
        return AutoUserMapper.Mapper.mapToUserDto(optionalUser.get());

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= userRepository.findAll();
        //return users.stream().map((user)->modelMapper.map(user,UserDto.class))
            //    .collect(Collectors.toList());
        return users.stream().map((user)->AutoUserMapper.Mapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser= userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(updatedUser);
        //return modelMapper.map(updatedUser,UserDto.class);
        return AutoUserMapper.Mapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
