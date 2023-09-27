package nl.delphinity.ssm.repository.dao;

import jakarta.persistence.PersistenceException;
import nl.delphinity.ssm.repository.interfaces.IGenericDAO;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

    private final Class<T> persistentClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void setSession(Session s) {
        this.session = s;
    }

    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session has not been set on DAO before usage");
        return session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public T save(T entity) {
        try {
            getSession().beginTransaction();
            getSession().persist(entity);
            getSession().getTransaction().commit();
        } catch (PersistenceException e) {

            entity = null;

            if (getSession().getTransaction() != null)
                getSession().getTransaction().rollback();

            if(e.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
                System.out.println(cve.getSQLException().getSQLState());
                throw (ConstraintViolationException) e.getCause();
            }

        }

        return entity;
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {

        List<T> result = new ArrayList<>();

        try {
            getSession().beginTransaction();

            for (T entity : entities) {
                getSession().persist(entity);
                result.add(entity);
            }

            getSession().getTransaction().commit();
        } catch (PersistenceException e) {

            if (getSession().getTransaction() != null)
                getSession().getTransaction().rollback();

            if(e.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
                System.out.println(cve.getSQLException().getSQLState());
                throw (ConstraintViolationException) e.getCause();
            }

        }

        return result;
    }

    @Override
    public void delete(T entity) {
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
    }

    @Override
    public Optional<T> findById(ID id) {
        getSession().beginTransaction();
        T entity = 	getSession().find(getPersistentClass(), id);
        getSession().getTransaction().commit();
        return Optional.of(entity);
    }

    @Override
    public List<T> findAll() {
        getSession().beginTransaction();

        JpaCriteriaQuery<T> query = getSession().getCriteriaBuilder().createQuery(getPersistentClass());
        query.select(query.from(getPersistentClass()));
        List<T> list = getSession().createQuery(query).getResultList();

        getSession().getTransaction().commit();

        return list;
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

}
