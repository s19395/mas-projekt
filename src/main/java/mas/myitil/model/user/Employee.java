package mas.myitil.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import mas.myitil.model.ticket.Ticket;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("Employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee extends User {

    @OneToMany(mappedBy="employee")
    @JsonBackReference
    private List<Ticket> tickets;
}
