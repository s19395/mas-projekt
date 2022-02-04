package mas.myitil.model.equipment;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EQUIPMENT_ID", updatable = false, nullable = false)
    private Long equipmentId;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "PRODUCT_NO")
    private String productNumber;
}
