package ada.wm2.midterm.repository;

import ada.wm2.midterm.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
    Optional<Users> findByEmailAndPassword(String email,String password);
}
