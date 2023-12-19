package com.remedies.josue.remedy.entities;

import com.remedies.josue.remedy.dtos.InsertRemedyDTO;
import com.remedies.josue.remedy.dtos.Laboratory;
import com.remedies.josue.remedy.dtos.Route;
import com.remedies.josue.remedy.dtos.UpdateRemedyDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="remedies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedy {

    public Remedy(InsertRemedyDTO data) {
        this.active = true;
        this.name = data.name();
        this.quantity = data.quantity();
        this.validity = data.validity();
        this.lot = data.lot();
        this.route = data.route();
        this.laboratory = data.laboratory();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private LocalDateTime validity;
    private String lot;

    @Enumerated(EnumType.STRING)
    private Route route;

    @Enumerated(EnumType.STRING)
    private Laboratory laboratory;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "active")
    private Boolean active;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void updateData(UpdateRemedyDTO data) {
        if(data.name() != null) {
            this.name = data.name();
        }
        if(data.route() != null) {
            this.route = data.route();
        }
        if(data.laboratory() != null) {
            this.laboratory = data.laboratory();
        }
        if(data.validity() != null) {
            this.validity = data.validity();
        }
        if(data.lot() != null) {
            this.lot = data.lot();
        }
    }
}
