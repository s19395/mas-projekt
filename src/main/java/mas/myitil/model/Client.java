package mas.myitil.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Client")
public class Client extends User {

    @Column(name = "PHONE_NUMBER", nullable = true)
    private String phoneNumber;
}
