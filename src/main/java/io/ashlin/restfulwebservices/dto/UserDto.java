package io.ashlin.restfulwebservices.dto;

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
    private String firstName;
    private String lastName;
    private String email ;
}
