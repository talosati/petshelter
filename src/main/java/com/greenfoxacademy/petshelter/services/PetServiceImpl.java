package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Human;
import com.greenfoxacademy.petshelter.models.Pet;
import com.greenfoxacademy.petshelter.repositories.HumanRepository;
import com.greenfoxacademy.petshelter.repositories.PetRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

  PetRepository petRepository;
  HumanRepository humanRepository;

  @Autowired
  public PetServiceImpl(PetRepository petRepository, HumanRepository humanRepository) {
    this.petRepository = petRepository;
    this.humanRepository = humanRepository;
  }

  @Override
  public List<Pet> getAllPets() {
    List<Pet> pets = new ArrayList<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public List<String> getPetsWhichOwnerIsOlderThanGivenAge(int humanAge) {
    return petRepository.getAllPets().stream()
        .filter(pet -> pet.getOwner() != null)
        .filter(pet -> pet.getOwner().getHumanAge() > humanAge)
        .map(pet -> pet.getPetName())
        .collect(Collectors.toList());
  }

  @Override
  public boolean isPetNameAddedAlready(String petName) {
    Optional<Pet> foundPet = petRepository.findByPetName(petName);
    if (foundPet.isPresent()) {
      Pet pet = foundPet.get();
      return pet.getPetName().equals(petName);
    }
    return false;
  }

  @Override
  public void addPet(Pet pet) {
    petRepository.save(pet);
  }

  @Override
  public void savePetWithOwner(Pet pet, long humanId) {
    Optional<Human> optionalOwner = humanRepository.findById(humanId);
    if (optionalOwner.isPresent()) {
      Human owner = optionalOwner.get();
      pet.setOwner(owner);
      this.addPet(pet);
    }
  }
}
