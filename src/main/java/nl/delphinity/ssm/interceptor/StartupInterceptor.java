package nl.delphinity.ssm.interceptor;

import nl.delphinity.ssm.repository.factory.DAOFactories;
import nl.delphinity.ssm.repository.factory.DAOFactory;
import nl.delphinity.ssm.repository.util.HibernateSessionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupInterceptor implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateSessionManager.close();
    }

}
