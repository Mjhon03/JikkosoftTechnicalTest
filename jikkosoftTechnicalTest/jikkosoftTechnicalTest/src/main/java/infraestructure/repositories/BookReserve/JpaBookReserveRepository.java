package infraestructure.repositories.BookReserve;

import infraestructure.entities.BookReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookReserveRepository extends JpaRepository<BookReserveEntity, Long> {
}
