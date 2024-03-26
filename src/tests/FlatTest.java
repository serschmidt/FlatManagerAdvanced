import models.Flat;
import models.House;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlatTest {

    private Flat flat1;
    private Flat flat2;
    private House house;

    @BeforeEach
    public void setUp() {
        this.house = new House("Townhouse", 2008);
        this.flat1 = new Flat("first flat", 50, 5, false, null, house);
        this.flat2 = new Flat( "second flat", 40, 2, true, null, house);
    }

    @Test
    void compareToTest() {
        Assertions.assertEquals(10, flat1.compareTo(flat2));
        Assertions.assertEquals(-10, flat2.compareTo(flat1));
    }

//    @Test
//    public void setCountTest(){
//        flat1.setCount(3);
//        Assertions.assertEquals(3,flat1.count);
//    }

    @Test
    void getIdTest() {
        Assertions.assertEquals(flat2.getId()-1, flat1.getId());
    }

    @Test
    void validateIdTest() {
        long id = flat1.getId();
        Assertions.assertTrue(flat1.validateId(id));
        Assertions.assertFalse(flat1.validateId(1234));
    }

    @Test
    void getNameTest() {
        Assertions.assertEquals("first flat", flat1.getName());
    }


    @Test
    void setNameTest() {
        flat1.setName("mit Aussicht");
        Assertions.assertEquals("mit Aussicht", flat1.getName());
    }

    @Test
    void validateNameTest() {
        Assertions.assertTrue(flat1.validateName(flat1.getName()));
        Assertions.assertTrue(flat1.validateName("first flat"));
        Assertions.assertFalse(flat1.validateName("sdfg5wer10pjn158nz20qay25kjh30abc"));


    }

    @Test
    void getAreaTest() {
        Assertions.assertEquals(50, flat1.getArea());
    }

    @Test
    void setAreaTest() {
        int newArea = 70;
        flat1.setArea(newArea);
        Assertions.assertEquals(70, flat1.getArea());
    }

    @Test
    void validateAreaTest() {
        Assertions.assertTrue(flat1.validateArea(flat1.getArea()));
        Assertions.assertTrue(flat1.validateArea(50));
        Assertions.assertFalse(flat1.validateArea(250));
    }

    @Test
    void getNumberOfRoomsTest() {
        Assertions.assertEquals(5,flat1.getNumberOfRooms());
    }
    @Test
    void setNumberOfRoomsTest() {
        flat1.setNumberOfRooms(5);
        Assertions.assertEquals(5,flat1.getNumberOfRooms());
    }

    @Test
    void validateNumberOfRoomsTest() {
        Assertions.assertTrue(flat1.validateNumberOfRooms(5));
        Assertions.assertFalse(flat1.validateNumberOfRooms(-1));
        Assertions.assertFalse(flat1.validateNumberOfRooms(10));
    }


    @Test
    void isBalconyTest() {
        Assertions.assertEquals(false,flat1.isBalcony());
    }
    @Test
    void setBalconyTest() {
        flat1.setNumberOfRooms(5);
        Assertions.assertEquals(5,flat1.getNumberOfRooms());
    }




}
