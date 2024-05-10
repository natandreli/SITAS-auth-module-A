package com.sitas.authmodule.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Login Request DTO")
public class LoginRequestDTO {
    @Schema(description = "e-mail")
    @NotBlank(message = "e-mail is required")
    @Email(message = "e-mail must be a valid email address")
    @Size(max = 200, message = "e-mail must be less than 200 characters")
    private String mail;

    @Schema(description = "Password")
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 200, message = "Password must be between 8 and 200 characters")
    private String accessKey;
}
