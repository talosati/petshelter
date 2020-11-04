package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Pet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PetService {
  List<Pet> getAllPets();

  List<String> getPetsWhichOwnerIsOlderThanGivenAge(int humanAge);

  boolean isPetNameAddedAlready(String petName);

  void addPet(Pet pet);

  void savePetWithOwner(Pet pet, long humanId);
}
