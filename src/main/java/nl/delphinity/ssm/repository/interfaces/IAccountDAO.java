package nl.delphinity.ssm.repository.interfaces;

import nl.delphinity.ssm.domain.Account;

public interface IAccountDAO extends IGenericDAO<Account, Long> {

    Account findByEmail(String email);

}
