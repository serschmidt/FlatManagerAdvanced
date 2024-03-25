import models.House;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HouseTest {
    private House home;
    private House home2;

    @BeforeEach
    public void setUp(){
        this.home = new House("Kirpichka", 1979);
        this.home2 = new House("Palast", 1950);
    }

    @Test
    public void gettersTest() {
        Assertions.assertSame("Kirpichka",home.getName());
        Assertions.assertNotSame("Kirpichka",home2.getName());
        Assertions.assertEquals(1950,home2.getYear());
        Assertions.assertNotEquals(1980, home.getYear());
    }

    @Test
    public void settersTest() {
        home.setName("Some House");
        Assertions.assertSame("Some House",home.getName());
        home2.setName("New House");
        Assertions.assertNotSame("Kirpichka",home2.getName());
        Assertions.assertNotSame(null,home2.getName());
        home.setYear(1960);
        Assertions.assertEquals(1960, home.getYear());
        home2.setYear(1940);
        Assertions.assertNotEquals(1950,home2.getYear());
        Assertions.assertNotEquals(0,home2.getYear());
    }

    @Test
    public void yearValidationTest() {
        Assertions.assertTrue(House.validateYear(1920));
        Assertions.assertFalse(House.validateYear(2050));
        Assertions.assertFalse(House.validateYear(0));
        Assertions.assertTrue(House.validateYear(1850));
        Assertions.assertTrue(House.validateYear(2030));
    }

    @Test
    public void compareToTest() {
        Assertions.assertEquals(home.compareTo(home2),29);
        Assertions.assertNotEquals(home2.compareTo(home2),-1);
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals(home.toString(), " The house is named " + home.getName() + " and it was built in  " + home.getYear()+".");
    }



}
