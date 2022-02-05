package com.nikitka.codecovtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class StupidTest {
    private Main main = new Main();

    @Test
    public void privateStringTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method privateString = main.getClass().getDeclaredMethod("privateString");
        assertNotNull(privateString);
        privateString.setAccessible(true);
        String actual = privateString.invoke(main).toString();
        assertEquals("private", actual);
    }

    @Test
    public void fieldsTest() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        assertEquals(main.getClass().getDeclaredFields().length, 4);
        assertEquals(main.getClass().getDeclaredField("a").getInt(main), 0);
        Field privateStringField = main.getClass().getDeclaredField("b");
        privateStringField.setAccessible(true);
        assertEquals(privateStringField.get(main), null);
    }
}
