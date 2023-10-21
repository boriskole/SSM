package nl.delphinity.ssm.repository.factory;

import nl.delphinity.ssm.repository.interfaces.*;

public abstract class DAOFactory {

    private static DAOFactory factory;

    public static DAOFactory getFactory() {
        return factory;
    }

    public static void setFactory(Class<? extends DAOFactory> factory) {
        try {
            DAOFactory.factory = factory.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create DAOFactory: " + factory);
        }
    }

    public abstract IAccountDAO getAccountDAO();
    public abstract IPersoonDAO getPersoonDAO();
    public abstract IKlantDAO getKlantDAO();
    public abstract IBestellingDAO getBestellingDAO();
    public abstract IBeheerderDAO getBeheerderDAO();

}
