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
        return new ResponseEntity<Remedio>(remedio, HttpStatus.CREATED);
    }

    @GetMapping
    public List<RemedioDTO> listar() {
        return remedioRepository.findAll().stream().map(RemedioDTO::new).toList();
    }

    @PutMapping("/{id}")
    @Transactional
    public Remedio atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarRemedioDTO data) {
        Remedio remedioEncontrado = remedioRepository.getReferenceById(id);
        remedioEncontrado.atualizarDados(data);
        Remedio remedioSalvo = remedioRepository.save(remedioEncontrado);
        return remedioSalvo;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        remedioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
