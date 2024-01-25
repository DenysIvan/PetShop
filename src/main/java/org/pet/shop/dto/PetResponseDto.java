package org.pet.shop.dto;

import java.util.UUID;

public class PetResponseDto {
    private UUID id;
    private String name;
    private String type;
    private String color;
    private ParentsDto parents;


    public PetResponseDto() {
    }

    public PetResponseDto(UUID id, String name, String type, String color, ParentsDto parents) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.parents = parents;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ParentsDto getParents() {
        return parents;
    }

    public void setParents(ParentsDto parentDto) {
        this.parents = parentDto;
    }
}
