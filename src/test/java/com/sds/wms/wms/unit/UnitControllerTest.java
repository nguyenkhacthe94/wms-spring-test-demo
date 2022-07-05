package com.sds.wms.wms.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sds.wms.wms.units.Unit;
import com.sds.wms.wms.units.UnitController;
import com.sds.wms.wms.units.UnitService;

@SpringBootTest
@AutoConfigureMockMvc
public class UnitControllerTest {
    @Autowired
    UnitController unitController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UnitService unitService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(unitController).isNotNull();
    }

    @Test
    public void insertShouldReturnObjectWithHttpCode201() throws Exception {
        Unit unit = new Unit("plt", "palette");
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/u").content(objectMapper.writeValueAsString(unit))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(unit)));
        unitService.delete(unit);
    }

    @Test
    public void insertExistedUnitShouldReturnHttpCode400() throws Exception {
        Unit unit = new Unit("kg", "kilogam");
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/u").content(objectMapper.writeValueAsString(unit))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
