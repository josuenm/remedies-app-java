package com.remedies.josue.remedy;

import com.remedies.josue.entities.Remedy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedyRepository extends JpaRepository<Remedy, Long> {

}
