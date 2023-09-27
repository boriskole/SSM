package nl.delphinity.ssm.repository.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IGenericDAO<T, ID extends Serializable> {

    T save(T entity);

    Iterable<T> saveAll(Iterable<T> entities);

    void delete(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

}
