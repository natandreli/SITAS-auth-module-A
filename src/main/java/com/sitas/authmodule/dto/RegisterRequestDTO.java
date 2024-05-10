package com.sitas.authmodule.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "Register Request DTO")
public class RegisterRequestDTO {

    @Schema(description = "ID Type")
    @NotNull(message = "ID Identification Type is required")
    @Min(value = 1, message = "ID Identification Type must be a positive number")
    private int idIdentificationType;

    @Schema(description = "Identification Number")
    @NotBlank(message = "Identification Number is required")
    @Size(max = 20, message = "Identification Number must be less than 20 characters")
    private String identificationNumber;

    @Schema(description = "First Name")
    @NotBlank(message = "First Name is required")
    @Size(max = 200, message = "First Name must be less than 200 characters")
    private String firstName;

    @Schema(description = "Last Name")
    @NotBlank(message = "Last Name is required")
    @Size(max = 200, message = "Last Name must be less than 200 characters")
    private String lastName;

    @Schema(description = "Genre")
    @NotBlank(message = "Genre is required")
    @Pattern(regexp = "^[MF]$", message = "Genre must be 'M' or 'F'")
    private String genre;

    @Schema(description = "Birth Date")
    @NotNull(message = "Birth Date is required")
    private LocalDate birthDate;

    @Schema(description = "Phone Number")
    @Size(max = 20, message = "Phone Number must be less than 20 characters")
    private String phoneNumber;

    @Schema(description = "Country of Residence")
    @NotBlank(message = "Country of Residence is required")
    @Size(max = 50, message = "Country of Residence must be less than 50 characters")
    private String country;

    @Schema(description = "Province of Residence")
    @NotBlank(message = "Province of Residence is required")
    @Size(max = 50, message = "Province of Residence must be less than 50 characters")
    private String province;

    @Schema(description = "City of Residence")
    @NotBlank(message = "City of Residence is required")
    @Size(max = 50, message = "City of Residence must be less than 50 characters")
    private String city;

    @Schema(description = "Residence Address")
    @NotBlank(message = "Residence Address is required")
    @Size(max = 200, message = "Residence Address must be less than 200 characters")
    private String residence;

    @Schema(description = "e-mail")
    @NotBlank(message = "e-mail is required")
    @Email(message = "e-mail must be a valid email address")
    @Size(max = 200, message = "e-mail must be less than 200 characters")
    private String mail;

    @Schema(description = "Password")
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^" +
            "&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?!.*[#='$;%]).{8,}$",
            message = "Password must contain at least one digit, one " +
                    "lowercase letter, one uppercase letter, one symbol, " +
                    "and cannot contain #='$;%")
    @Size(min = 8, max = 200, message = "Password must be between 8 and 200 characters")
    private String accessKey;
}