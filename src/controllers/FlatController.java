package controllers;

import models.Flat;
import models.FlatRepository;
import models.IRepository;

public class FlatController implements IFlatController {
    private IRepository<Flat> flatRepo;

    public FlatController() {
        flatRepo = new FlatRepository();
    }

    @Override
    public void add(Flat flat) {
        flatRepo.put("1212", flat);
    }
}