package mas.myitil.model.equipment;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@ToString(callSuper=true, includeFieldNames=true)
@DiscriminatorValue("Phone")
public class Phone extends Asset {
    @Column(name = "IMEI", nullable = true)
    private String imei;
}
