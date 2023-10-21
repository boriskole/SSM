package nl.delphinity.ssm.domain;

import jakarta.persistence.*;
import nl.delphinity.ssm.repository.factory.DAOFactory;

import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Klant extends Persoon {

    @OneToMany(mappedBy = "klant")
    private Set<Bestelling> bestellingen;

    public Klant() { }

    public Klant(Long id, Account account, String voornaam, String tussenvoegsel, String achternaam) {
        super(id, account, voornaam, tussenvoegsel, achternaam);
    }

    public Klant(Account account, String voornaam, String tussenvoegsel, String achternaam) {
        super(account, voornaam, tussenvoegsel, achternaam);
    }

    public Set<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(Set<Bestelling> bestellingen) {
        this.bestellingen = bestellingen;
    }

    public void addBestelling(Bestelling bestelling) {

        if (bestellingen == null)
            bestellingen = new HashSet<>();

        bestelling.setKlant(this);
        bestellingen.add(bestelling);
        DAOFactory.getFactory().getBestellingDAO().save(bestelling);

    }

}
