package mas.myitil.model.user.repository;

import mas.myitil.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    @Query(
            value = "select * from user where dtype = 'Client' || dtype = 'Employee'",
            nativeQuery = true)
    List<User> findAllClientsAndEmployees();
}
