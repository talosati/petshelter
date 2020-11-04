package com.greenfoxacademy.petshelter.repositories;

import com.greenfoxacademy.petshelter.models.Pet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

  Optional<Pet> findByPetName(String petName);

  @Query(value = "SELECT * FROM pet", nativeQuery = true)
  List<Pet> getAllPets();

}
