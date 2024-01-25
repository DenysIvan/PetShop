package org.pet.shop.dto;

public class PetRequestDto {
    private String name;
    private String type;
    private String color;
    private ParentsDto parents;

    public PetRequestDto() {
    }

    public PetRequestDto(String name, String type, String color, ParentsDto parents) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.parents = parents;
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

    public void setParents(ParentsDto parents) {
        this.parents = parents;
    }
}
