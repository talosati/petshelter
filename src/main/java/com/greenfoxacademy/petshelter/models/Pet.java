package com.greenfoxacademy.petshelter.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long petId;
  private String petName;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Human owner;

  public Pet() {
  }

  public Pet(long petId, String petName) {
    this.petId = petId;
    this.petName = petName;
  }
}
