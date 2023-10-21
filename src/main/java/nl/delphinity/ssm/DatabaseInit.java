package nl.delphinity.ssm;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nl.delphinity.ssm.domain.Account;
import nl.delphinity.ssm.domain.Beheerder;
import nl.delphinity.ssm.domain.Bestelling;
import nl.delphinity.ssm.domain.Klant;
import nl.delphinity.ssm.domain.type.BestellingStatus;
import nl.delphinity.ssm.domain.type.BestellingType;
import nl.delphinity.ssm.repository.factory.DAOFactories;
import nl.delphinity.ssm.repository.factory.DAOFactory;
import nl.delphinity.ssm.repository.util.HibernateSessionManager;

import java.util.List;

public class DatabaseInit {

    public static void main(String... args) {

        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.init();

        Account a = new Account(
                "user@example.com",
                BCrypt.withDefaults().hashToString(
                        12,
                        "admin".toCharArray()
                )
        );

        Beheerder b = new Beheerder(
                a,
                "Boris",
                null,
                "Kole"
        );

        a.setPersoon(b);

        DAOFactory.getFactory().getBeheerderDAO().save(b);
        DAOFactory.getFactory().getAccountDAO().save(a);

        HibernateSessionManager.close();

    }

}
