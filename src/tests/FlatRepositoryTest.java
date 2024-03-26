import models.*;
import models.Flat;
import models.FlatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FlatRepositoryTest {

    private FlatRepository flatrepo;
    private FlatRepository flatrepoEmpty;
    private Flat flat1;
    private Flat flat2;

    private House home;

    @BeforeEach
    public void setUp() {
        this.home = new House("Palast",1967);
        this.flat1 = new Flat("first flat",50,5,false,null,home);
        this.flat2 = new Flat("second flat",40,2,true,null,home);
        this.flatrepoEmpty = new FlatRepository();
        this.flatrepo = new FlatRepository();
        flatrepo.add(flat1);
        flatrepo.add(flat2);
    }

    @Test
    public void getIndexByIdTest() {
        long number = flat1.getId();
        Assertions.assertEquals(0,flatrepo.getIndexById(number));
        Assertions.assertEquals(1,flatrepo.getIndexById(number+1));
        Assertions.assertEquals(-1,flatrepo.getIndexById(number+5));
        Assertions.assertEquals(-1,flatrepoEmpty.getIndexById(number+5));
    }

    @Test
    public void getFlatsTest() {
        Assertions.assertEquals(2,flatrepo.getFlats().size());
    }

    @Test
    public void getFlatByIndexTest() {
        Assertions.assertEquals(this.flat1, flatrepo.getFlatByIndex(0));
    }

    @Test
    public void updateFlatFieldsTest() {
        House GLAAD = new House("GLA Arms Dealer", 2003);
        Flat newFlat = new Flat("Kabus1",27,1,true,Furnish.LITTLE, GLAAD);
        flatrepo.updateName(0, "Kabus1");
        flatrepo.updateArea(0, 27);
        flatrepo.updateRoom(0, 1);
        flatrepo.updateBalcony(0, true);
        flatrepo.updateFurnish(0, Furnish.LITTLE);
        flatrepo.updateHouseName(0,"GLA Arms Dealer");
        flatrepo.updateHouseYear(0,2003);
        flatrepo.add(newFlat);
        Assertions.assertNotEquals(newFlat, flatrepo.getFlatByIndex(0));
        Assertions.assertEquals(newFlat, flatrepo.getFlatByIndex(2));
    }

    @Test
    public void removeByIndexTest(){
        flatrepo.removeByIndex(1);
        Assertions.assertEquals(1, flatrepo.getFlats().size());
    }

    @Test
    public void clearTest(){
        flatrepo.clear();
        Assertions.assertEquals(0, flatrepo.getFlats().size());
    }

    @Test
    public void removeHeadTest(){
        Assertions.assertEquals(flat1, flatrepo.removeHead());
    }

    @Test
    public void addFlatTest(){
        House GLAAD = new House("GLA Arms Dealer", 2003);
        Flat newFlat = new Flat("Kabus1",27,1,true,Furnish.LITTLE, GLAAD);
        flatrepo.add(newFlat);
        Assertions.assertEquals(newFlat, flatrepo.getFlatByIndex(2));
    }

    @Test
    public void sortingTest(){
        House GLAAD = new House("GLA Arms Dealer", 2003);
        Flat newFlat = new Flat("kabus1",27,1,true,Furnish.LITTLE, GLAAD);
        flatrepo.add(newFlat);
        flatrepo.sortByName();
        Assertions.assertEquals(newFlat, flatrepo.getFlatByIndex(1));
        flatrepo.sortByArea();
        Assertions.assertEquals(flat2, flatrepo.getFlatByIndex(1));
        flatrepo.sortByRooms();
        Assertions.assertEquals(newFlat, flatrepo.getFlatByIndex(0));
        flatrepo.sortById();
        Assertions.assertEquals(newFlat, flatrepo.getFlatByIndex(2));
    }

    @Test
    public void getNewCountTest(){
        House GLAAD = new House("GLA Arms Dealer", 2003);
        Flat newFlat = new Flat("kabus1",27,1,true,Furnish.LITTLE, GLAAD);
        flatrepo.add(newFlat);
        Assertions.assertEquals(8, flatrepo.getNewCount());
    }

}
