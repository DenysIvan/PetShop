package org.pet.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.pet.shop.dto.ParentsDto;
import org.pet.shop.dto.PetRequestDto;
import org.pet.shop.dto.PetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class PetshopApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreatePet() throws Exception {
        PetRequestDto requestDto = createSamplePetRequestDto();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void testGetAllPets() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pets"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void testGetPetById() throws Exception {
        PetRequestDto requestDto = createSamplePetRequestDto();

        String createResponse = mockMvc.perform(MockMvcRequestBuilders
                        .post("/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andReturn().getResponse().getContentAsString();

        PetResponseDto petResponseDto = objectMapper.readValue(createResponse, PetResponseDto.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pets/{id}", petResponseDto.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(petResponseDto.getId().toString()));
    }

    @Test
    public void testUpdatePet() throws Exception {
        PetRequestDto requestDto = createSamplePetRequestDto();

        String postResponse = mockMvc.perform(MockMvcRequestBuilders
                        .post("/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andReturn().getResponse().getContentAsString();

        PetResponseDto petResponseDto = objectMapper.readValue(postResponse, PetResponseDto.class);

        // Update the color
        requestDto.setColor("white");

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/pets/{id}", petResponseDto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.color").value("white"));
    }

    private PetRequestDto createSamplePetRequestDto() {
        PetRequestDto requestDto = new PetRequestDto();
        requestDto.setName("Katy Purry");
        requestDto.setType("cat");
        requestDto.setColor("black");

        ParentsDto parents = new ParentsDto();
        parents.setMother(UUID.fromString("917cb6b1-60c3-44d6-b30d-baa0ca2fa132"));
        parents.setFather(UUID.fromString("f9275923-a3de-460a-a9bd-d6341185adef"));
        requestDto.setParents(parents);

        return requestDto;
    }
}

