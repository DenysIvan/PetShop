package org.pet.shop.repository;

import org.pet.shop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetshopRepository extends JpaRepository<Pet, UUID> {
}
