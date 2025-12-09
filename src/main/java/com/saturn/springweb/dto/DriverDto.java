package com.saturn.springweb.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {

    private Long id;

    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotBlank(message = "team cannot be empty")
    private String team;

    @Max(value = 50)
    @Min(value = 14)
    private Integer age;

    @Pattern(regexp = "^(DRIVER|ENGINEER)$", message = "role can be either DRIVER or ENGINEER")
    @NotBlank
    private String role;

    private LocalDate dateOfJoining;

    private Boolean isActive;
}
