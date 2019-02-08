package com.boot.dasboot;

import com.boot.dasboot.controllers.ShipWreckController;
import com.boot.dasboot.models.Shipwreck;
import com.boot.dasboot.repositories.ShipWreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShipWreckControllerTest {
    @InjectMocks
    private ShipWreckController shipWreckController;

    @Mock
    private ShipWreckRepository shipWreckRepository;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipWreckGet(){
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setId(1L);
        when(shipWreckRepository.getOne(1L)).thenReturn(shipwreck);

        Shipwreck shipwreck1 = shipWreckController.get(1L);
        assertThat(shipwreck1.getId(), is(1L));
    }

    @Test
    public void testShipWreckGetResponse() throws Exception {
        this.mockMvc.perform(get("/api/v1/shipwrecks")).andExpect(status().isOk());
    }
}
