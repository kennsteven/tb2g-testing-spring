package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource("classpath:laurel.properties")
@ActiveProfiles("laurel-properties")
@SpringJUnitConfig(classes = PropertiesLaurelTest.TestConfi.class)
public class PropertiesLaurelTest {

    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.sfg")
    static class TestConfi{
    }

    @Autowired
    HearingInterpreter hearingInterpreter;


    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();

        assertEquals("lAuReL", word);
    }
}
