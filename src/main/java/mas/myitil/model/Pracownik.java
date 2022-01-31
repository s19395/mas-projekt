package mas.myitil.model;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Pracownik")
public class Pracownik extends Osoba {
}
