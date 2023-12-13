package com.remedios.josue.dtos.remedio;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

public record CadastroRemedioDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @Enumerated
        Via via,
        @NotBlank(message = "O lote é obrigatório")
        String lote,

        @DecimalMin(value = "0", message = "A quantidade é obrigatória")
        @NotNull(message = "A quantidade é obrigatório")
        int quantidade,

        @Future(message = "A data precisa ser futura")
        LocalDateTime validade,
        @Enumerated
        Laboratorio laboratorio
        ) {
}
