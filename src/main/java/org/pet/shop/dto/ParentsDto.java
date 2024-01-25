package org.pet.shop.dto;

import java.util.UUID;

public class ParentsDto {

    private UUID mother;
    private UUID father;

    public ParentsDto() {
    }

    public ParentsDto(UUID mother, UUID father) {
        this.mother = mother;
        this.father = father;
    }

    public UUID getMother() {
        return mother;
    }

    public void setMother(UUID mother) {
        this.mother = mother;
    }

    public UUID getFather() {
        return father;
    }

    public void setFather(UUID father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "parents{" +
               "mother" + mother +
               ", father" + father +
               '}';
    }
}
