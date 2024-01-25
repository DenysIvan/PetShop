package org.pet.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.pet.shop.dto.PetRequestDto;
import org.pet.shop.dto.PetResponseDto;
import org.pet.shop.model.Pet;

@Mapper
public interface PetMapper {

    @Mappings({
            @Mapping(source = "parents.mother", target = "motherId"),
            @Mapping(source = "parents.father", target = "fatherId")})
    Pet mapToEntity(PetRequestDto petRequestDto);

    @Mappings({
            @Mapping(source = "motherId", target = "parents.mother"),
            @Mapping(source = "fatherId", target = "parents.father")})
    PetResponseDto mapToResponseDto(Pet pet);

    void updatePetFromDto(PetRequestDto petRequestDto, @MappingTarget Pet pet);
}
