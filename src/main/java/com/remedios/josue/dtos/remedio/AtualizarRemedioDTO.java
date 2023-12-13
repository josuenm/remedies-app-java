package com.remedios.josue.dtos.remedio;

import java.time.LocalDateTime;

public record AtualizarRemedioDTO(
        String nome,
        int quantidade,
        Via via,
        Laboratorio laboratorio,
        String lote,
        LocalDateTime validade,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
