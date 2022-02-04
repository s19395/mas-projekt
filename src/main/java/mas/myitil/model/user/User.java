package mas.myitil.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "EMAIL", nullable = false)
    private String email;
}
