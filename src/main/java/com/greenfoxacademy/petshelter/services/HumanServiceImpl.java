package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Human;
import com.greenfoxacademy.petshelter.repositories.HumanRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanServiceImpl implements HumanService {

  HumanRepository humanRepository;

  @Autowired
  public HumanServiceImpl(HumanRepository humanRepository) {
    this.humanRepository = humanRepository;
  }

  @Override
  public List<Human> getAllHumen() {
    List<Human> humen = new ArrayList<>();
    humanRepository.findAll().forEach(humen::add);
    return humen;
  }

  @Override
  public boolean isHumanNameSavedAlready(String humanName) {
    Optional<Human> foundHuman = humanRepository.findByHumanName(humanName);
    if (foundHuman.isPresent()) {
      Human human = foundHuman.get();
      return human.getHumanName().equals(humanName);
    }
    return false;
  }

  @Override
  public void addHuman(Human human) {
    humanRepository.save(human);
  }

  @Override
  public Human findHumanById(long humanId) {
    Optional<Human> optionalHuman = humanRepository.findById(humanId);
    if (optionalHuman.isPresent()) {
      return optionalHuman.get();
    }
    return null;
  }

  @Override
  public void deleteHuman(long humanId) {
    Optional<Human> optionalHuman = humanRepository.findById(humanId);
    if (optionalHuman.isPresent()) {
      Human human = optionalHuman.get();
      humanRepository.delete(human);
    }
  }

  @Override
  public void editHuman(long humanId, String humanName, int humanAge) {
    Optional<Human> optionalHuman = humanRepository.findById(humanId);
    if (optionalHuman.isPresent()) {
      Human human = optionalHuman.get();
      human.setHumanName(humanName);
      human.setHumanAge(humanAge);
      humanRepository.save(human);
    }
  }

  @Override
  public Human getHumanByGivenParameters(long humanId, String humanName) throws NotFoundException {
    Optional<Human> optionalHuman = humanRepository.findById(humanId);
    if (optionalHuman.isPresent()) {
      Human human = optionalHuman.get();
      if (human.getHumanName().equals(humanName)) {
        return human;
      } else {
        throw new IllegalArgumentException("Human name is not valid");
      }
    } else {
      throw new NotFoundException("Human with the given ID cannot be found");
    }
  }
}
