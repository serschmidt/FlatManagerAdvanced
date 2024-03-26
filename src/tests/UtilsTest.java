import models.Furnish;
import controllers.Utils;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UtilsTest {
//    @BeforeEach
//    public void onStart() {
        String i = "22";
        String d = "3.14";
        String line = "abc";
        String emptyLine = "";
        String nullLine = null;
        String isTrue = "true";
        String isFalse = "false";
        //furnish variables:
    String furnDesigner = "DESIGNER";
    String furnNone = "NONE";
    String furnBad = "BAD";
    String furnLittle = "LITTLE";

//    }

    @Test
    void testUtilsIsInt() {
        Assertions.assertTrue(Utils.isInt(i));
        Assertions.assertFalse(Utils.isInt(d));
        Assertions.assertFalse(Utils.isInt(line));
        Assertions.assertFalse(Utils.isInt(emptyLine));
        Assertions.assertFalse(Utils.isInt(nullLine));
    }

    @Test
    void testUtilsIsString() {
        Assertions.assertTrue(Utils.isString(line));
        Assertions.assertFalse(Utils.isString(emptyLine));
//        Assertions.assertFalse(Utils.isString(nullLine));
    }

    @Test
    void testUtilsIsLong() {
        Assertions.assertTrue(Utils.isLong(i));
        Assertions.assertFalse(Utils.isLong(d));
        Assertions.assertTrue(Utils.isLong(line));
        Assertions.assertFalse(Utils.isLong(emptyLine));
        Assertions.assertFalse(Utils.isLong(nullLine));
    }


    @Test
    void testUtilsIsDouble() {
        Assertions.assertTrue(Utils.isDouble(i));
        Assertions.assertTrue(Utils.isDouble(d));
        Assertions.assertFalse(Utils.isDouble(line));
        Assertions.assertFalse(Utils.isDouble(emptyLine));
        Assertions.assertFalse(Utils.isDouble(nullLine));
    }

    @Test
    void testUtilsIsBoolean() {
        Assertions.assertFalse(Utils.isBoolean(i));
        Assertions.assertFalse(Utils.isBoolean(d));
        Assertions.assertFalse(Utils.isBoolean(line));
        Assertions.assertFalse(Utils.isBoolean(emptyLine));
        Assertions.assertFalse(Utils.isBoolean(nullLine));
        Assertions.assertTrue(Utils.isBoolean(isTrue));
        Assertions.assertTrue(Utils.isBoolean(isFalse));
    }

    @Test
    void testUtilsIsEnum() {
        Assertions.assertFalse(Utils.isEnum(i, Furnish.class));
        Assertions.assertFalse(Utils.isEnum(d, Furnish.class));
        Assertions.assertFalse(Utils.isEnum(line, Furnish.class));
        Assertions.assertFalse(Utils.isEnum(emptyLine, Furnish.class));
        Assertions.assertFalse(Utils.isEnum(nullLine, Furnish.class));
        Assertions.assertFalse(Utils.isEnum(isTrue, Furnish.class));
        Assertions.assertFalse(Utils.isEnum(isFalse, Furnish.class));
        Assertions.assertTrue(Utils.isEnum(furnDesigner, Furnish.class));
        Assertions.assertTrue(Utils.isEnum(furnBad, Furnish.class));
        Assertions.assertTrue(Utils.isEnum(furnLittle, Furnish.class));
        Assertions.assertTrue(Utils.isEnum(furnNone, Furnish.class));
    }

}
