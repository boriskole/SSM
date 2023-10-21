package nl.delphinity.ssm.repository.dao;

import nl.delphinity.ssm.domain.Persoon;
import nl.delphinity.ssm.repository.interfaces.IPersoonDAO;

public class PersoonDAO extends GenericDAO<Persoon, Long> implements IPersoonDAO {

    @Override
    public Persoon findByEmail(String email) {
        getSession().beginTransaction();
        Persoon entity = getSession().createQuery("FROM Persoon WHERE email = :email", Persoon.class)
                .setParameter("email", email)
                .getSingleResult();
        getSession().getTransaction().commit();
        return entity;
    }

}
