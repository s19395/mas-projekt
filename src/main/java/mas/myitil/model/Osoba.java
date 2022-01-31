package mas.myitil.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OSOBA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "IMIE", nullable = false)
    private String imie;

    @Column(name = "NAZWISKO", nullable = false)
    private String nazwisko;

    @Column(name = "EMAIL", nullable = false)
    private String email;
}
