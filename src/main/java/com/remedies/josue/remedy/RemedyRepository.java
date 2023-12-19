package com.remedies.josue.remedy;

import com.remedies.josue.remedy.models.Remedy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedyRepository extends JpaRepository<Remedy, Long> {

}
