package nl.delphinity.ssm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Beheerder extends Persoon {

    public Beheerder() { }

    public Beheerder(Long id, Account account, String voornaam, String tussenvoegsel, String achternaam) {
        super(id, account, voornaam, tussenvoegsel, achternaam);
    }

    public Beheerder(Account account, String voornaam, String tussenvoegsel, String achternaam) {
        super(account, voornaam, tussenvoegsel, achternaam);
    }

}