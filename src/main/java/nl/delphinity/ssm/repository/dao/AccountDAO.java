package nl.delphinity.ssm.repository.dao;

import nl.delphinity.ssm.domain.Account;
import nl.delphinity.ssm.repository.interfaces.IAccountDAO;

import java.util.Optional;

public class AccountDAO extends GenericDAO<Account, Long> implements IAccountDAO {

    @Override
    public Optional<Account> findByEmail(String email) {
        getSession().beginTransaction();
        Account entity = getSession().createQuery("FROM Account WHERE email = :email", Account.class)
                .setParameter("email", email)
                .uniqueResult();
        getSession().getTransaction().commit();
        return Optional.ofNullable(entity);
    }

}