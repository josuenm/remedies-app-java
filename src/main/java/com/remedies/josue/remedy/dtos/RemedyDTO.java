package com.remedies.josue.remedy.dtos;

import com.remedies.josue.entities.Remedy;

import java.time.LocalDateTime;

public record RemedyDTO(
        Long id,
        String name,
        int quantity,
        Route route,
        Laboratory laboratory,
        String lot,
        LocalDateTime validity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean active
) {
    public RemedyDTO(Remedy remedy) {
        this(
                remedy.getId(),
                remedy.getName(),
                remedy.getQuantity(),
                remedy.getRoute(),
                remedy.getLaboratory(),
                remedy.getLot(),
                remedy.getValidity(),
                remedy.getCreatedAt(),
                remedy.getUpdatedAt(),
                remedy.getActive()
        );
    }
}
