package org.pet.shop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    private String name;
    private String type;
    private String color;

    @Column(name = "mother_id")
    private UUID motherId;

    @Column(name = "father_id")
    private UUID fatherId;

    public Pet() {
    }

    public Pet(UUID id, String name, String type, String color, UUID motherId, UUID fatherId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.motherId = motherId;
        this.fatherId = fatherId;
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

    public UUID getMotherId() {
        return motherId;
    }

    public void setMotherId(UUID motherId) {
        this.motherId = motherId;
    }

    public UUID getFatherId() {
        return fatherId;
    }

    public void setFatherId(UUID fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (!Objects.equals(id, pet.id)) return false;
        if (!Objects.equals(name, pet.name)) return false;
        if (!Objects.equals(type, pet.type)) return false;
        if (!Objects.equals(color, pet.color)) return false;
        if (!Objects.equals(motherId, pet.motherId)) return false;
        return Objects.equals(fatherId, pet.fatherId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (motherId != null ? motherId.hashCode() : 0);
        result = 31 * result + (fatherId != null ? fatherId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", type='" + type + '\'' +
               ", color='" + color + '\'' +
               ", parenths:{" +
               " motherId=" + motherId +
               ", fatherId=" + fatherId +
               "}\n}";
    }
}
