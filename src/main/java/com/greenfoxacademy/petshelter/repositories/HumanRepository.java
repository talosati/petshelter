package com.greenfoxacademy.petshelter.repositories;

import com.greenfoxacademy.petshelter.models.Human;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends CrudRepository<Human, Long> {

  Optional<Human> findByHumanName(String humanName);
}
