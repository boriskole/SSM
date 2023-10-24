package nl.delphinity.ssm.action.klant;

import nl.delphinity.ssm.domain.Account;
import nl.delphinity.ssm.domain.SecuredAction;
import nl.delphinity.ssm.domain.type.PersoonType;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

@SecuredAction(type = PersoonType.KLANT)
public class HomeAction implements SessionAware {

    private String voornaam;
    private Map<String, Object> session;

    public String home() {
        Account account = (Account) session.get("account");
        voornaam = account.getPersoon().getVoornaam();
        return "success";
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

}
