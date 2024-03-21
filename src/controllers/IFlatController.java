package controllers;

import models.Flat;
import models.FlatRepository;

import java.util.List;

public interface IFlatController {

    public List<Flat> show();
    public void addFlat(Flat obj);

    public FlatRepository getFlatRepo();

    public int findListIndexByFlatID(String args);

}