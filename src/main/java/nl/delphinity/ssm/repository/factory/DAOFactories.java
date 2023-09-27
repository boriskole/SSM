package nl.delphinity.ssm.repository.factory;

public enum DAOFactories {

    HIBERNATE(HibernateDAOFactory.class);

    private final Class<? extends DAOFactory> factory;

    DAOFactories(Class<? extends DAOFactory> factory) {
        this.factory = factory;
    }

    public Class<? extends DAOFactory> getFactory() {
        return factory;
    }

}
