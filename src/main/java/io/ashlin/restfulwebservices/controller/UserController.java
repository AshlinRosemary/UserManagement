package io.ashlin.restfulwebservices.controller;


import io.ashlin.restfulwebservices.dto.UserDto;
import io.ashlin.restfulwebservices.entity.User;
import io.ashlin.restfulwebservices.exception.ErrorDetails;
import io.ashlin.restfulwebservices.exception.ResourceNotFoundException;
import io.ashlin.restfulwebservices.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
@Tag(
        name ="CRUD REST APIs for User Resource",
        description = "CRUD REST Apis-Create User, Update User,get User ,get All User ,Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @Operation(
            summary= "Create User Rest Api",
            description="create User Rest-API is used to save user in a Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 created "
    )
    @PostMapping("/create")
    public ResponseEntity<UserDto> CreateUser(@Valid @RequestBody UserDto user){
        UserDto savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary= "Get User by ID Rest Api",
            description="To get the user details based on the given ID, we get single user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user=userService.getUserByID(userId);
        return new ResponseEntity<>(user ,HttpStatus.OK);
    }

    @Operation(
            summary= "Get all Users ",
            description="To get the all user details in Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto > users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK) ;
    }

    @Operation(
            summary= "Update User details by ID ",
            description="Update any details of the user corresponding to given ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @Valid@RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser=userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @Operation(
            summary= "Delete User details by ID ",
            description="Delete details of the user corresponding to given ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted user with given ID",HttpStatus.OK);
    }
/*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "User_NOT_Found"
        );
    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }*/
}
