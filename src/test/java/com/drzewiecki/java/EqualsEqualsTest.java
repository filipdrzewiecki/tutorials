package com.drzewiecki.java;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class EqualsEqualsTest {

    @Test
    void testHash() {
        Boolean bool1 = new Boolean(true);
        Boolean bool2 = new Boolean(true);

        assert bool1 =! bool2;
        assert bool1.equals(bool2);

    }

}
