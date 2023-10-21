package nl.delphinity.ssm.domain;

import jakarta.persistence.*;
import nl.delphinity.ssm.domain.type.BestellingStatus;
import nl.delphinity.ssm.domain.type.BestellingType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bestelling")
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BestellingType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BestellingStatus status;

    @Column(nullable = false)
    private String opmerking;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klant_id", nullable = false)
    private Klant klant;

    @Column(nullable = false, name = "aanmaak_datum")
    @CreationTimestamp
    private LocalDateTime aanmaakDatum;

    @Column(nullable = false, name = "wijzig_datum")
    @UpdateTimestamp
    private LocalDateTime wijzigDatum;

    public Bestelling() { }

    public Bestelling(Long id, BestellingType type, BestellingStatus status, String opmerking) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.opmerking = opmerking;
    }

    public Bestelling(BestellingType type, BestellingStatus status, String opmerking) {
        this.type = type;
        this.status = status;
        this.opmerking = opmerking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BestellingType getType() {
        return type;
    }

    public void setType(BestellingType type) {
        this.type = type;
    }

    public BestellingStatus getStatus() {
        return status;
    }

    public void setStatus(BestellingStatus status) {
        this.status = status;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public LocalDateTime getAanmaakDatum() {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(LocalDateTime aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }

    public LocalDateTime getWijzigDatum() {
        return wijzigDatum;
    }

    public void setWijzigDatum(LocalDateTime wijzigDatum) {
        this.wijzigDatum = wijzigDatum;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());

        return result;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Bestelling other = (Bestelling) obj;

        return Objects.equals(id, other.id);

    }

    @Override
    public String toString() {
        return "Bestelling{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", opmerking='" + opmerking + '\'' +
                ", aanmaakDatum=" + aanmaakDatum +
                ", wijzigDatum=" + wijzigDatum +
                '}';
    }

}
