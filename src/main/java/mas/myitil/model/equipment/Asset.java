package mas.myitil.model.equipment;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ASSET")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Asset extends Equipment {

    @Column(name = "ASSET_NO", nullable = false)
    private String assetNo;

    @Column(name = "SERIAL_NO", nullable = true)
    private String serialNo;

    @Column(name = "PURCHASE_DATE", nullable = true)
    private LocalDate purchaseDate;

    @Column(name = "CONDITION", nullable = true)
    @Enumerated(EnumType.STRING)
    private AssetCondition condition;
}
