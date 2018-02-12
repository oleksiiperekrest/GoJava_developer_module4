package dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    T getById(ID id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    void deleteById(ID id);

}
