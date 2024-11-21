package infraestructure.repositories.Book;

import domain.models.Book;
import domain.ports.out.book.BookRepositoryPort;
import infraestructure.entities.BookEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaBookAdapter  implements BookRepositoryPort {

    private final JpaBookRepository bookRepository;

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = BookEntity.fromDomainModel(book);
        return bookRepository.save(bookEntity).toDomainModel();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id.longValue()).map(BookEntity::toDomainModel);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll().stream()
                .map(BookEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> update(Integer id, Book book) {
        if(bookRepository.existsById(id.longValue())){
            BookEntity updatedProductEntity = bookRepository.save(BookEntity.fromDomainModel(book));
            return Optional.of(updatedProductEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(bookRepository.existsById(id.longValue())){
            bookRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }
}
