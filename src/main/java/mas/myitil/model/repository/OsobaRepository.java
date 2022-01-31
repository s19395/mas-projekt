package mas.myitil.model.repository;

import mas.myitil.model.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Long> {

}
