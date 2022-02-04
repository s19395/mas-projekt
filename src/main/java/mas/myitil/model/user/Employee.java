package mas.myitil.model.user;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Employee")
public class Employee extends User {
}
