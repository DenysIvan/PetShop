package org.pet.shop.service;

import org.pet.shop.dto.PetRequestDto;
import org.pet.shop.dto.PetResponseDto;

import java.util.List;
import java.util.UUID;

public interface PetshopService {
    PetResponseDto savePet(PetRequestDto petRequestDto);

    List<PetResponseDto> getAllPets();

    PetResponseDto getPetById(UUID id);

    PetResponseDto updatePet(UUID id, PetRequestDto petRequestDto);
}
