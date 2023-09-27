package nl.delphinity.ssm.repository.interfaces;

import nl.delphinity.ssm.domain.Account;

import java.util.Optional;

public interface IAccountDAO extends IGenericDAO<Account, Long> {

    Optional<Account> findByEmail(String email);

}
