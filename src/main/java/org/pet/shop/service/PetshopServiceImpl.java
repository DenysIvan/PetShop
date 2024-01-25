package org.pet.shop.service;

import org.mapstruct.factory.Mappers;
import org.pet.shop.dto.PetRequestDto;
import org.pet.shop.dto.PetResponseDto;
import org.pet.shop.mapper.PetMapper;
import org.pet.shop.model.Pet;
import org.pet.shop.repository.PetshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PetshopServiceImpl implements PetshopService {

    private final PetMapper petMapper = Mappers.getMapper(PetMapper.class);
    private final PetshopRepository petshopRepository;

    @Autowired
    public PetshopServiceImpl(PetshopRepository petshopRepository) {
        this.petshopRepository = petshopRepository;
    }

    @Override
    public PetResponseDto savePet(PetRequestDto petRequestDto) {
        Pet pet = petMapper.mapToEntity(petRequestDto);
        Pet savedPet = petshopRepository.save(pet);
        return petMapper.mapToResponseDto(savedPet);
    }

    @Override
    public List<PetResponseDto> getAllPets() {
        List<Pet> pets = petshopRepository.findAll();
        return pets.stream()
                .map(petMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetResponseDto getPetById(UUID id) {
        Pet pet = petshopRepository.findById(id).orElse(null);
        return pet != null ? petMapper.mapToResponseDto(pet) : null;
    }

    @Override
    public PetResponseDto updatePet(UUID id, PetRequestDto petRequestDto) {
        Pet existingPet = petshopRepository.findById(id).orElse(null);
        if (existingPet != null) {
            petMapper.updatePetFromDto(petRequestDto, existingPet);
            Pet updatedPet = petshopRepository.save(existingPet);
            return petMapper.mapToResponseDto(updatedPet);
        }
        return null;
    }
}
