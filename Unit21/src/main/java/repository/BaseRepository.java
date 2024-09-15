package repository;

import java.util.List;

public interface BaseRepository<T> {
    T find(int id);

    List<T> findAll();

    boolean delete(int id);

    boolean update(T entity);

    boolean save(T entity);
}
