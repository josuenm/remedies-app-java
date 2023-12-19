package com.remedies.josue.remedy;

import com.remedies.josue.remedy.dtos.UpdateRemedyDTO;
import com.remedies.josue.remedy.dtos.InsertRemedyDTO;
import com.remedies.josue.remedy.models.Remedy;
import com.remedies.josue.remedy.dtos.RemedyDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/remedy")
public class RemedyController {
    @Autowired
    private RemedyRepository remedyRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Remedy> insert(@RequestBody @Valid InsertRemedyDTO data) {
        Remedy remedy = remedyRepository.save(new Remedy(data));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(remedy.getId())
                .toUri();

        return ResponseEntity.created(location).body(remedy);
    }

    @GetMapping
    public ResponseEntity<List<RemedyDTO>> list() {
        var remedies = remedyRepository.findAll().stream().map(RemedyDTO::new).toList();
        return ResponseEntity.ok(remedies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemedyDTO> getOne(@PathVariable Long id) {
        var remedy = remedyRepository.getReferenceById(id);
        return ResponseEntity.ok(new RemedyDTO(remedy));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UpdateRemedyDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateRemedyDTO data) {
        Remedy remedy = remedyRepository.getReferenceById(id);
        remedy.updateData(data);
        return ResponseEntity.ok(new UpdateRemedyDTO(remedy));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        remedyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/disable/{id}")
    @Transactional
    public ResponseEntity<Void> disable(@PathVariable Long id) {
        Remedy remedy = remedyRepository.getReferenceById(id);
        remedy.setActive(false);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/enable/{id}")
    @Transactional
    public ResponseEntity<?> enable(@PathVariable Long id) {
        Remedy remedy = remedyRepository.getReferenceById(id);
        remedy.setActive(true);
        return ResponseEntity.noContent().build();
    }
}
