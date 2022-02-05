package com.nikitka.codecovtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StupidTest {

    @Test
    public void stupidTest() {
        assertEquals("Hello, World!", Main.getMessage());
    }
}
