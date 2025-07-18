package org.litefarm.app.farm_management.infra.rest.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.infra.rest.v1.FarmRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FarmRestController.class)
public class FarmRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void givenUserCreatesFarm_whenNameIsNotGiven_thenThrowBusinessException() throws Exception {
        FarmRestController.FarmCreationRequest farmCreation = new FarmRestController.FarmCreationRequest(
                null,
                "lorem ipsum dolurm",
                "0928301230",
                "imperial"
        );

        String json = objectMapper.writeValueAsString(farmCreation);

        mockMvc.perform(post("/api/v1/farm")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

@Test
    public void givenUserCreatesFarm_whenPayloadHasValidInfo_thenFarmIsCreated() throws Exception {
        FarmRestController.FarmCreationRequest farmCreation = new FarmRestController.FarmCreationRequest(
                "Alicia",
                "lorem ipsum dolurm",
                "0928301230",
                "imperial"
        );

        String json = objectMapper.writeValueAsString(farmCreation);

        mockMvc.perform(post("/api/v1/farm")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("alan"));
    }
}
