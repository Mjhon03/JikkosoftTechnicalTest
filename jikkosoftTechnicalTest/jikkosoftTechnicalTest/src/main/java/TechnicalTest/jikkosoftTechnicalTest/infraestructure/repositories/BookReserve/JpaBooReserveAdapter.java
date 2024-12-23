package TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.BookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.bookReserve.BookReverseRepositoryPort;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.BookReserveEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaBooReserveAdapter implements BookReverseRepositoryPort {
    private final JpaBookReserveRepository bookReserveRepository;


    @Override
    public BookReserve save(BookReserve book) {
        BookReserveEntity bookReserveEntity = BookReserveEntity.fromDomainModel(book);
        return bookReserveRepository.save(bookReserveEntity).toDomainModel();
    }

    @Override
    public Optional<BookReserve> findById(Integer id) {
        return bookReserveRepository.findById(Long.valueOf(id)).map(BookReserveEntity::toDomainModel);
    }

    @Override
    public List<BookReserve> findAll() {
        return bookReserveRepository.findAll().stream()
                .map(BookReserveEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookReserve> update(Integer id, BookReserve book) {
        if(bookReserveRepository.existsById(Long.valueOf(book.getBook().getId()))){
            BookReserveEntity updatedBookReserveEntity = bookReserveRepository.save(BookReserveEntity.fromDomainModel(book));
            return Optional.of(updatedBookReserveEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(bookReserveRepository.existsById(Long.valueOf(id))){
            bookReserveRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }
}
