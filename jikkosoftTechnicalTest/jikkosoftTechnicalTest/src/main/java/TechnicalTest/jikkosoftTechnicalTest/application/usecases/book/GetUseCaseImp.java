package TechnicalTest.jikkosoftTechnicalTest.application.usecases.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.book.GetBookUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.book.BookRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GetUseCaseImp implements GetBookUseCase {
    private final BookRepositoryPort bookRepositoryPort;

    public GetUseCaseImp(BookRepositoryPort BookRepositoryPort) {
        this.bookRepositoryPort = BookRepositoryPort;
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepositoryPort.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepositoryPort.findAll();
    }

}
