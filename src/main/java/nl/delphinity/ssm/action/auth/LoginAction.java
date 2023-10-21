package nl.delphinity.ssm.action.auth;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nl.delphinity.ssm.domain.Account;
import nl.delphinity.ssm.repository.factory.DAOFactory;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class LoginAction implements SessionAware {

    private Map<String, Object> session;
    private String email;
    private String wachtwoord;

    public String login() {

        if (email == null || wachtwoord == null)
            return "error";

        Account foundAccount = DAOFactory.getFactory()
                .getAccountDAO()
                .findByEmail(email);

        if (foundAccount == null)
            return "wrong";

        boolean isWachtwoordGelijk = BCrypt.verifyer().verify(
                wachtwoord.toCharArray(),
                foundAccount.getWachtwoord()
        ).verified;

        if (isWachtwoordGelijk) {
            session.put("account", foundAccount);
            if (foundAccount.getPersoon().isBeheerder())
                return "beheerder";
            return "klant";
        }

        return "wrong";

    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

}
