package TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.User;

import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
