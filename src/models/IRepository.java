package models;


public interface IRepository<T> {
    public T get(String id);

    public void add(T obj);
}