package mas.myitil.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;
import mas.myitil.model.ticket.Ticket;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@ToString(callSuper=true, includeFieldNames=true)
@DiscriminatorValue("Client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client extends User {

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @OneToMany(mappedBy="client")
    @JsonManagedReference
    private List<Ticket> tickets;
}