package com.randikalakmal.todoapp.DTO;

import com.randikalakmal.todoapp.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Gender gender;

}
