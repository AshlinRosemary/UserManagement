package io.ashlin.restfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
//Create DTO, thru DTO we are going to communicate
    private Long id;
    @NotEmpty(message ="User Firstname should not be null or empty")
    private String firstName;
    @NotEmpty(message ="User Lastname should not be null or empty")
    private String lastName;
    @NotEmpty(message ="User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email ;
    //private String emailAddress;
}
