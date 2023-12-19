package com.remedies.josue.remedy.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record InsertRemedyDTO(
        @NotBlank(message = "Name is required")
        String name,
        @Enumerated(EnumType.STRING)
        Route route,
        @NotBlank(message = "Lot is required")
        String lot,

        @DecimalMin(value = "0")
        @NotNull(message = "Quantity is Required")
        int quantity,

        @Future(message = "The validity date must be in the future")
        LocalDateTime validity,

        @Enumerated(EnumType.STRING)
        Laboratory laboratory
        ) {
}
