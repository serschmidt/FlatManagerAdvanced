package tests;

import controllers.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testUtils() {
        String i = "10";
        String line = "abc";
        String emptyLine = "";

        Assertions.assertTrue(Utils.isInt(i));
        Assertions.assertFalse(Utils.isInt(line));
        Assertions.assertFalse(Utils.isInt(emptyLine));
    }

}
