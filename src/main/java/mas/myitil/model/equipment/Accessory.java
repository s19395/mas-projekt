package mas.myitil.model.equipment;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ACCESSORY")
public class Accessory extends Equipment {
}
