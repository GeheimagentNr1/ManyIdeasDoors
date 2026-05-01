package de.geheimagentnr1.manyideas_doors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ManyIdeasDoorsTest {

    @Test
    void modIdIsValid() {

        String modId = "manyideas_doors";
        assertTrue( modId.matches( "[a-z][a-z0-9_]{1,63}" ) );
    }
}
