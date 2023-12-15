package com.remedios.josue.controllers;

import com.remedios.josue.dtos.remedio.AtualizarRemedioDTO;
import com.remedios.josue.dtos.remedio.CadastroRemedioDTO;
import com.remedios.josue.dtos.remedio.RemedioDTO;
import com.remedios.josue.models.Remedio;
import com.remedios.josue.repositories.remedio.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/remedio")
public class RemedioController {
    @Autowired
    private RemedioRepository remedioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Remedio> cadastrar(@RequestBody @Valid CadastroRemedioDTO data) {
        Remedio remedio = remedioRepository.save(new Remedio(data));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(remedio.getId())
                .toUri();

        return ResponseEntity.created(location).body(remedio);
    }

    @GetMapping
    public ResponseEntity<List<RemedioDTO>> listar() {
        var remedios = remedioRepository.findAll().stream().map(RemedioDTO::new).toList();
        return ResponseEntity.ok(remedios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemedioDTO> pegarUm(@PathVariable Long id) {
        var remedio = remedioRepository.getReferenceById(id);
        return ResponseEntity.ok(new RemedioDTO(remedio));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AtualizarRemedioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarRemedioDTO data) {
        Remedio remedio = remedioRepository.getReferenceById(id);
        remedio.atualizarDados(data);
        return ResponseEntity.ok(new AtualizarRemedioDTO(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        remedioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        Remedio remedio = remedioRepository.getReferenceById(id);
        remedio.inativarOuAtivar(false);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<?> ativar(@PathVariable Long id) {
        Remedio remedio = remedioRepository.getReferenceById(id);
        remedio.inativarOuAtivar(true);
        return ResponseEntity.noContent().build();
    }
}
