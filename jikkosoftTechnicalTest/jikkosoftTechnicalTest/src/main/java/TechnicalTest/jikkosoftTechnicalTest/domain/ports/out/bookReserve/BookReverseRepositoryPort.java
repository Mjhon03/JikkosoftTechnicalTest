package TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;

import java.util.List;
import java.util.Optional;

public interface BookReverseRepositoryPort {
    BookReserve save(BookReserve book);

    Optional<BookReserve> findById(Integer id);

    List<BookReserve> findAll();

    Optional<BookReserve> update(Integer id, BookReserve book);

    Boolean deleteById(Integer id);

}
