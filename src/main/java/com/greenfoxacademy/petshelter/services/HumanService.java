package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Human;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface HumanService {

  List<Human> getAllHumen();

  boolean isHumanNameSavedAlready(String humanName);

  void addHuman(Human human);

  Human findHumanById(long humanId);

  void deleteHuman(long humanId);

  void editHuman(long humanId, String humanName, int humanAge);

  Human getHumanByGivenParameters(long humanId, String humanName) throws NotFoundException;
}
