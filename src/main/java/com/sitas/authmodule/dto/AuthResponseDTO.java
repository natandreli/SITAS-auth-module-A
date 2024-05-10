package com.sitas.authmodule.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Auth Response DTO")
public class AuthResponseDTO {
    @Schema(description = "token")
    private String token;
}
