package nl.delphinity.ssm.repository.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {

    T save(T entity);

    Iterable<T> saveAll(Iterable<T> entities);

    void delete(T entity);

    T findById(ID id);

    List<T> findAll();

}
