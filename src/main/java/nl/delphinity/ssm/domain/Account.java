package nl.delphinity.ssm.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String wachtwoord;

    @Column(nullable = false)
    private Integer machtigingen;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime aanmaakDatum;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime wijzigDatum;

    public Account() { }

    public Account(Long id, String email, String wachtwoord, Integer machtigingen) {
        this.id = id;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.machtigingen = machtigingen;
    }

    public Account(String email, String wachtwoord, Integer machtigingen) {
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.machtigingen = machtigingen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getMachtigingen() {
        return machtigingen;
    }

    public void setMachtigingen(Integer machtigingen) {
        this.machtigingen = machtigingen;
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

        Account other = (Account) obj;

        return Objects.equals(id, other.id);

    }

    @Override
    public String toString() {
        return "Account [id=" + id
                + ", email=" + email
                + ", wachtwoord=" + wachtwoord
                + ", aanmaakDatum=" + aanmaakDatum
                + ", wijzigDatum=" + wijzigDatum
                + "]";
    }

}
