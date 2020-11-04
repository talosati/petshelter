package com.greenfoxacademy.petshelter.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

  public Error(String error) {
    this.error = error;
  }

  private String error;

}

