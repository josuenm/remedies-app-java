package com.remedios.josue.dtos.remedio;

import com.remedios.josue.models.Remedio;

import java.time.LocalDateTime;

public record AtualizarRemedioDTO(
        String nome,
        int quantidade,
        Via via,
        Laboratorio laboratorio,
        String lote,
        LocalDateTime validade,
        Boolean ativo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public AtualizarRemedioDTO(Remedio remedio) {
        this(
                remedio.getNome(),
                remedio.getQuantidade(),
                remedio.getVia(),
                remedio.getLaboratorio(),
                remedio.getLote(),
                remedio.getValidade(),
                remedio.getAtivo(),
                remedio.getCreatedAt(),
                remedio.getUpdatedAt()
        );
    }
}
