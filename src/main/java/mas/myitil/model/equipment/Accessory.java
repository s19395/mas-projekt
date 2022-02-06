package mas.myitil.model.equipment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;
import mas.myitil.model.user.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "accessory")
@ToString(callSuper=true, includeFieldNames=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "equipmentId", scope = Long.class)
public class Accessory extends Equipment {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonManagedReference
    private User user;
}
