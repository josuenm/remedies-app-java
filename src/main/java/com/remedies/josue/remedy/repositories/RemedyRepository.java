package com.remedies.josue.remedy.repositories;

import com.remedies.josue.remedy.entities.Remedy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedyRepository extends JpaRepository<Remedy, Long> {

}
