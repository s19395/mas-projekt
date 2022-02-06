package mas.myitil.model.repair;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import mas.myitil.model.equipment.Asset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "repair")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ticketId", scope = Long.class)
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "repair_id", updatable = false, nullable = false)
    private Long repairId;

    @Column(name = "repair_from", nullable = false)
    private LocalDateTime repairFrom;

    @Column(name = "repair_to", nullable = false)
    private LocalDateTime repairTo;

    @Column(name = "price", nullable = true)
    private Integer price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    @JsonManagedReference
    private RepairShop repairShop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="equipment_id")
    @JsonManagedReference
    private Asset asset;
}
