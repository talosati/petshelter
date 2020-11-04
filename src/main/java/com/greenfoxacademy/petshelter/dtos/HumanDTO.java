package com.greenfoxacademy.petshelter.dtos;

import lombok.Getter;

@Getter
public class HumanDTO {

  private String humanName;

  public HumanDTO(String humanName) {
    this.humanName = humanName;
  }
}
