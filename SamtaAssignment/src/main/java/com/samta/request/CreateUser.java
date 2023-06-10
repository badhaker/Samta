package com.samta.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name can contain only alphabets")
    private String firstName;
    @Pattern(regexp = "^[A-Za-z.'\\s]+$", message = "Last name can contain alphabets, a single quote, and a dot")
    private String lastName;
    @Email(message = "Invalid email format")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{8,12}$", message = "Password must meet the criteria")
    private String password;
}
