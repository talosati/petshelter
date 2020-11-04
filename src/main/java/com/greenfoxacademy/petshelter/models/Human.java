package com.greenfoxacademy.petshelter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Human {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long humanId;

  private String humanName;

  @JsonIgnore
  private int humanAge;

  @OneToMany(fetch = FetchType.LAZY,
      mappedBy = "owner", cascade = CascadeType.ALL)
  private List<Pet> pets;

  public Human() {
    this.pets = new ArrayList<>();
  }
}
