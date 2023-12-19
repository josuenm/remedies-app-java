package com.remedies.josue.remedy;

import com.remedies.josue.remedy.entities.Remedy;

import java.time.LocalDateTime;

public record UpdateRemedyDTO(
        String name,
        int quantity,
        Route route,
        Laboratory laboratory,
        String lot,
        LocalDateTime validity,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public UpdateRemedyDTO(Remedy remedy) {
        this(
                remedy.getName(),
                remedy.getQuantity(),
                remedy.getRoute(),
                remedy.getLaboratory(),
                remedy.getLot(),
                remedy.getValidity(),
                remedy.getActive(),
                remedy.getCreatedAt(),
                remedy.getUpdatedAt()
        );
    }
}
