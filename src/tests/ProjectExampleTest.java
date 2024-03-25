import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Flat {}

class FlatRepository{
    private List<Flat> list = new ArrayList<>();

    public void add(Flat flat){
        list.add(flat);
    }
    public Flat getLast(){
        return list.get(list.size()-1);
    }
}


public class ProjectExampleTest {

    Flat flat;
    FlatRepository repo;
    @BeforeEach
    public void onSetup(){
        this.flat = new Flat();
        this.repo = new FlatRepository();
    }
    @Test
    public void repoAddGetTest(){
        this.repo.add(this.flat);
        Flat lastFlat = repo.getLast();
        Assertions.assertEquals(this.flat, lastFlat);
    }


}
