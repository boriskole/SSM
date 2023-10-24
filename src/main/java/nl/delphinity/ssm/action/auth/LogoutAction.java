package nl.delphinity.ssm.action.auth;

import nl.delphinity.ssm.repository.util.HibernateSessionManager;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class LogoutAction implements SessionAware {

    private Map<String, Object> session;

    public String logout() {
        session.clear();
        HibernateSessionManager.getSessionFactory().getCurrentSession().close();
        return "success";
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

}
