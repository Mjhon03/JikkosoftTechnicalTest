package TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryPort {

    Book save(Book book);
    Optional<Book> findById(Integer id);
    List<Book> findAll();
    Optional<Book> update(Integer id, Book book);
    Boolean deleteById(Integer id);

}
