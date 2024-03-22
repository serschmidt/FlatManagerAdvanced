package models;


public interface IRepository<T> {
    public T get(String name);

    public void add(T obj);
}