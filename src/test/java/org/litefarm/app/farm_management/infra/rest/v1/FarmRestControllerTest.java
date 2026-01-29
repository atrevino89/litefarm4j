package org.litefarm.app.farm_management.infra.rest.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.infra.rest.v1.dto.FarmCreationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FarmRestController.class)
public class FarmRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void givenUserCreatesFarm_whenNameIsNotGiven_thenThrowBusinessException() throws Exception {
        var farmCreation = new FarmCreationRequestDTO(
                "",
                "This is the best farm from the NL",
                "95.384,-47.98937",
                "metric",
                "813045832",
                "Ketenstraat 2828, Amsterdam, 1433ll",
                "mxn",
                "s3://blablabla.com/123j23kl1n2n"
        );


        String json = objectMapper.writeValueAsString(farmCreation);

        mockMvc.perform(post("/api/v1/farm")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error.message").value("Name must not be blank"));
    }

    @Test
    public void givenUserCreatesFarm_whenNoteIsNotGiven_thenFarmIsCreated() throws Exception {
        var farmName = "La granja de tio chueco";
        var farmCreation = new FarmCreationRequestDTO(
                farmName,
                "",
                "95.384,-47.98937",
                "metric",
                "813045832",
                "Ketenstraat 2828, Amsterdam, 1433ll",
                "mxn",
                "s3://blablabla.com/123j23kl1n2n"
        );

        String json = objectMapper.writeValueAsString(farmCreation);

        mockMvc.perform(post("/api/v1/farm")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.farmId.value").isString());
    }

    @Test
    public void givenUserCreatesFarm_whenPayloadHasValidInfo_thenFarmIsCreated() throws Exception {
        var farmCreation = new FarmCreationRequestDTO(
                "La granja del tio chueco",
                "This is the best farm from the NL",
                "95.384,-47.98937",
                "metric",
                "813045832",
                "Ketenstraat 2828, Amsterdam, 1433ll",
                "mxn",
                "s3://blablabla.com/123j23kl1n2n"
        );

        String json = objectMapper.writeValueAsString(farmCreation);

        mockMvc.perform(post("/api/v1/farm")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.farmId.value").isString());
    }
}
