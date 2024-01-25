package org.pet.shop.controller;

import org.pet.shop.dto.PetRequestDto;
import org.pet.shop.dto.PetResponseDto;
import org.pet.shop.service.PetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetshopController {

    private final PetshopService petshopService;

    @Autowired
    public PetshopController(PetshopService petshopService) {
        this.petshopService = petshopService;
    }

    @PostMapping
    public ResponseEntity<PetResponseDto> savePet(@RequestBody PetRequestDto petRequestDto) {
        PetResponseDto savedPet = petshopService.savePet(petRequestDto);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDto>> getAllPets() {
        List<PetResponseDto> pets = petshopService.getAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetResponseDto> getPetById(@PathVariable UUID id) {
        PetResponseDto pet = petshopService.getPetById(id);
        return pet != null
                ? new ResponseEntity<>(pet, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PetResponseDto> updatePet(@PathVariable UUID id, @RequestBody PetRequestDto petRequestDto) {
        PetResponseDto updatedPet = petshopService.updatePet(id, petRequestDto);
        return updatedPet != null
                ? new ResponseEntity<>(updatedPet, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
