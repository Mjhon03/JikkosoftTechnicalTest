package application.usecases.bookReserve;

import domain.models.BookReserve;
import domain.ports.in.bookReserve.UpdateBookReserveUseCase;
import domain.ports.out.book.BookRepositoryPort;
import domain.ports.out.bookReserve.BookReverseRepositoryPort;

import java.util.Optional;

public class UpdateBookReserveUseCaseImp implements UpdateBookReserveUseCase {
    private final BookReverseRepositoryPort bookReverseRepositoryPort;

    public UpdateBookReserveUseCaseImp(BookReverseRepositoryPort bookReverseRepositoryPort) {
        this.bookReverseRepositoryPort = bookReverseRepositoryPort;
    }

    @Override
    public Optional<BookReserve> updateBookReserve(Integer id, BookReserve book) {
        return bookReverseRepositoryPort.findById(id);
    }
}
