package io.ashlin.restfulwebservices.controller;


import io.ashlin.restfulwebservices.dto.UserDto;
import io.ashlin.restfulwebservices.entity.User;
import io.ashlin.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<UserDto> CreateUser(@RequestBody UserDto user){
        UserDto savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user=userService.getUserByID(userId);
        return new ResponseEntity<>(user ,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto > users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK) ;
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser=userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted user with given ID",HttpStatus.OK);
    }

}
