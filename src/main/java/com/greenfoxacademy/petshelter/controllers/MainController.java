package com.greenfoxacademy.petshelter.controllers;

import com.greenfoxacademy.petshelter.models.Human;
import com.greenfoxacademy.petshelter.models.Pet;
import com.greenfoxacademy.petshelter.services.HumanService;
import com.greenfoxacademy.petshelter.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

  private HumanService humanService;
  private PetService petService;

  @Autowired
  public MainController(HumanService humanService,
                        PetService petService) {
    this.humanService = humanService;
    this.petService = petService;
  }

  @GetMapping(value = {"/", "/list-humans"})
  public String getListOfHumen(Model model) {
    model.addAttribute("humen", humanService.getAllHumen());
    return "list-humen";
  }

  @GetMapping("/list-pets")
  public String getListOfPets(Model model) {
    model.addAttribute("pets", petService.getAllPets());
    return "list-pets";
  }

  @GetMapping("/add-human")
  public String editHuman(Model model, @RequestParam(required = false) Boolean invalidHumanData,
                          @ModelAttribute Human human) {
    model.addAttribute("invalidHumanData", invalidHumanData);
    Human humanToRender =
        invalidHumanData == null ? new Human() : (invalidHumanData ? human : new Human());
    model.addAttribute("human", humanToRender);
    return "edit-human";
  }

  @PostMapping("/add-human")
  public String addNewHuman(@ModelAttribute Human human, RedirectAttributes attributes) {
    attributes.addFlashAttribute(human);
    if (humanService.isHumanNameSavedAlready(human.getHumanName())) {
      return "redirect:/add-human?invalidHumanData=true";
    } else {
      humanService.addHuman(human);
      return "redirect:/add-human?newHumanIsAdded=true";
    }
  }

  @PostMapping("/delete")
  public String deleteHumanByGivenId(@ModelAttribute Human human) {
    humanService.deleteHuman(human.getHumanId());
    return "redirect:/add-human?humanIsDeleted=true";
  }

  @PostMapping("/edit")
  public String editHumanByGivenParameters(@ModelAttribute Human human) {
    humanService.editHuman(human.getHumanId(), human.getHumanName(), human.getHumanAge());
    return "redirect:/add-human?humanIsEdited=true";
  }

  @GetMapping("/add-pet")
  public String editPet(Model model, @RequestParam(required = false) Boolean invalidPetData,
                        @ModelAttribute Pet pet) {
    model.addAttribute("invalidPetData", invalidPetData);
    Pet petToRender = invalidPetData == null ? new Pet() : (invalidPetData ? pet : new Pet());
    model.addAttribute("pet", petToRender);
    model.addAttribute("owners", humanService.getAllHumen());
    return "edit-pet";
  }

  @PostMapping("/add-pet")
  public String addNewPet(@ModelAttribute Pet pet,
                          @RequestParam("humanId") Long humanId,
                          RedirectAttributes attributes) {
    attributes.addFlashAttribute(pet);
    if (petService.isPetNameAddedAlready(pet.getPetName())) {
      return "redirect:/add-pet?invalidPetData=true";
    } else {
      petService.savePetWithOwner(pet, humanId);
      return "redirect:/add-pet?newPetIsAdded=true";
    }
  }
}
