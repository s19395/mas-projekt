package mas.myitil.model.equipment;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;
import mas.myitil.model.repair.Repair;
import mas.myitil.model.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "asset")
@ToString(callSuper=true, includeFieldNames=true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Asset extends Equipment {

    @Column(name = "asset_no", nullable = false)
    private String assetNo;

    @Column(name = "serial_no", nullable = true)
    private String serialNo;

    @Column(name = "purchase_date", nullable = true)
    private LocalDate purchaseDate;

    @Column(name = "condition", nullable = true)
    @Enumerated(EnumType.STRING)
    private AssetCondition condition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy="asset")
    @JsonManagedReference
    private List<Repair> repair;
}
