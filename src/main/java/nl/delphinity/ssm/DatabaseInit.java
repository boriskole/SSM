package nl.delphinity.ssm;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nl.delphinity.ssm.domain.Account;
import nl.delphinity.ssm.repository.factory.DAOFactories;
import nl.delphinity.ssm.repository.factory.DAOFactory;
import nl.delphinity.ssm.repository.util.HibernateSessionManager;

import java.util.List;

public class DatabaseInit {

    public static void main(String... args) {

        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.init();

        Account user = new Account(
                "user@example.com",
                BCrypt.withDefaults().hashToString(
                        12,
                        "user".toCharArray()
                ),
                1
        );

        Account admin = new Account(
                "admin@example.com",
                BCrypt.withDefaults().hashToString(
                        12,
                        "admin".toCharArray()
                ),
                2
        );

        DAOFactory.getFactory()
                .getAccountDAO()
                .saveAll(List.of(
                        user,
                        admin
                ));

        HibernateSessionManager.close();

    }

}
