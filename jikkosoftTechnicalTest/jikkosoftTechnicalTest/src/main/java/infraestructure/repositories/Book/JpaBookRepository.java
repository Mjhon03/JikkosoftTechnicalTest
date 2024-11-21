package infraestructure.repositories.Book;

import domain.models.Book;
import infraestructure.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository  extends JpaRepository<BookEntity, Long> {
}
