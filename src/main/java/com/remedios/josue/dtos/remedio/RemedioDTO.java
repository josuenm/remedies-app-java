package com.remedios.josue.dtos.remedio;

import com.remedios.josue.models.Remedio;

import java.time.LocalDateTime;

public record RemedioDTO(
        Long id,
        String nome,
        int quantidade,
        Via via,
        Laboratorio laboratorio,
        String lote,
        LocalDateTime validade,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean ativo
) {
    public RemedioDTO(Remedio remedio) {
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getQuantidade(),
                remedio.getVia(),
                remedio.getLaboratorio(),
                remedio.getLote(),
                remedio.getValidade(),
                remedio.getCreatedAt(),
                remedio.getUpdatedAt(),
                remedio.getAtivo()
        );
    }
}
