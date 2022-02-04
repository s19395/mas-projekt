package mas.myitil.model.user;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@ToString(callSuper=true, includeFieldNames=true)
@DiscriminatorValue("Client")
public class Client extends User {

    @Column(name = "PHONE_NUMBER", nullable = true)
    private String phoneNumber;
}
