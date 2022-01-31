package mas.myitil.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Klient")
public class Klient extends Osoba {

    @Column(name = "NUMER_TELEFONU", nullable = true)
    private String numerTelefonu;
}
