package TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.Book;

import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository  extends JpaRepository<BookEntity, Long> {
}
