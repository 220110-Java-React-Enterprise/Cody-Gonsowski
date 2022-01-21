package database;

public interface DataSourceCRUD<T> {
    // CRUD - create, read, update, delete
    //   return type not super necessary, but could be useful
    public T create(T t);
    public T read(Integer id);
    public T update(T t);
    public void delete(Integer id);
}
