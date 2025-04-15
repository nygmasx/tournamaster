package com.nygma.tournamaster;

import jakarta.validation.constraints.NotBlank;

public record UserCredentials(
        @NotBlank(message = "Email is mandatory") String email,
        @NotBlank(message = "Password is mandatory") String password)
{
}
