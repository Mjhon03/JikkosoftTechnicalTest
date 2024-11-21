package TechnicalTest.jikkosoftTechnicalTest.application.usecases.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.book.UpdateBookUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.book.BookRepositoryPort;

import java.util.Optional;

public class UpdateUseCaseImp implements UpdateBookUseCase {
    private final BookRepositoryPort bookRepositoryPort;


    public UpdateUseCaseImp(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Optional<Book> updateBook(Integer id, Book book) {
        return bookRepositoryPort.update(id, book);
    }
}
