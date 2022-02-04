package mas.myitil.model.equipment;

import lombok.Data;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@ToString(callSuper=true, includeFieldNames=true)
@DiscriminatorValue("Laptop")
public class Laptop extends Asset {

}
