package application.usecases.book;

import domain.models.Book;
import domain.ports.in.book.UpdateBookUseCase;
import domain.ports.out.book.BookRepositoryPort;

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
