package nl.delphinity.ssm.repository.factory;

import nl.delphinity.ssm.domain.*;
import nl.delphinity.ssm.repository.dao.*;
import nl.delphinity.ssm.repository.interfaces.*;
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

    @Override
    public IPersoonDAO getPersoonDAO() {
        GenericDAO<Persoon, Long> dao = null;
        try {
            dao = PersoonDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IPersoonDAO) dao;
    }

    @Override
    public IKlantDAO getKlantDAO() {
        GenericDAO<Klant, Long> dao = null;
        try {
            dao = KlantDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IKlantDAO) dao;
    }

    @Override
    public IBestellingDAO getBestellingDAO() {
        GenericDAO<Bestelling, Long> dao = null;
        try {
            dao = BestellingDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IBestellingDAO) dao;
    }

    @Override
    public IBeheerderDAO getBeheerderDAO() {
        GenericDAO<Beheerder, Long> dao = null;
        try {
            dao = BeheerderDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IBeheerderDAO) dao;
    }

}
