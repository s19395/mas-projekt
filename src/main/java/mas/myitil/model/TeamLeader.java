package mas.myitil.model;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("TeamLeader")
public class TeamLeader extends Osoba {
}
