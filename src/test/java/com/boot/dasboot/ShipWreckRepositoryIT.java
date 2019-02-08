package com.boot.dasboot;

import com.boot.dasboot.models.Shipwreck;
import com.boot.dasboot.repositories.ShipWreckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipWreckRepositoryIT {
    @Autowired
    private ShipWreckRepository shipWreckRepository;

    @Test
    public void testFindAll(){
        List<Shipwreck> shipWrecks = shipWreckRepository.findAll();
        assertThat(shipWrecks.size(), is(greaterThanOrEqualTo(0)));
    }

}
