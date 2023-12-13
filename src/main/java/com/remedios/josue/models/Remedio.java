package com.remedios.josue.models;

import com.remedios.josue.dtos.remedio.AtualizarRemedioDTO;
import com.remedios.josue.dtos.remedio.CadastroRemedioDTO;
import com.remedios.josue.dtos.remedio.Via;
import com.remedios.josue.dtos.remedio.Laboratorio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    public Remedio(CadastroRemedioDTO dados) {
        this.nome = dados.nome();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.lote = dados.lote();
        this.via = dados.via();
        this.laboratorio = dados.laboratorio();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade;
    private LocalDateTime validade;
    private String lote;

    @Enumerated(EnumType.STRING)
    private Via via;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void atualizarDados(AtualizarRemedioDTO data) {
        if(data.nome() != null) {
            this.nome = data.nome();
        }
        if(data.via() != null) {
            this.via = data.via();
        }
        if(data.laboratorio() != null) {
            this.laboratorio = data.laboratorio();
        }
        if(data.validade() != null) {
            this.validade = data.validade();
        }
        if(data.lote() != null) {
            this.lote = data.lote();
        }
    }
}
