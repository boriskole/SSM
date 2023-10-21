package nl.delphinity.ssm.repository.interfaces;

import nl.delphinity.ssm.domain.Persoon;

public interface IPersoonDAO extends IGenericDAO<Persoon, Long> {

    Persoon findByEmail(String email);

}
