package nl.delphinity.ssm.repository.factory;

import nl.delphinity.ssm.domain.Account;
import nl.delphinity.ssm.repository.dao.AccountDAO;
import nl.delphinity.ssm.repository.dao.GenericDAO;
import nl.delphinity.ssm.repository.interfaces.IAccountDAO;
import nl.delphinity.ssm.repository.util.HibernateSessionManager;
import org.hibernate.Session;

public class HibernateDAOFactory extends DAOFactory {

    protected Session getCurrentSession() {
        return HibernateSessionManager.getSessionFactory().openSession();
    }

    @Override
    public IAccountDAO getAccountDAO() {
        GenericDAO<Account, Long> dao = null;
        try {
            dao = AccountDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IAccountDAO) dao;
    }

}
