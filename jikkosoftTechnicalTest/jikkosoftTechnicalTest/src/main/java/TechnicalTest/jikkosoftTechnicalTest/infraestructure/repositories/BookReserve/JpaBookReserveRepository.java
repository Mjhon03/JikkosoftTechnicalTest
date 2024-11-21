package TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.BookReserve;

import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.BookReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JpaBookReserveRepository extends JpaRepository<BookReserveEntity, Long> {
}
