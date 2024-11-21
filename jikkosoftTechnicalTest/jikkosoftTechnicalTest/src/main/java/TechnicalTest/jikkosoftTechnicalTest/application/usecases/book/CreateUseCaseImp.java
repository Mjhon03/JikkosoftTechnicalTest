package TechnicalTest.jikkosoftTechnicalTest.application.usecases.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.book.CreateBookUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.book.BookRepositoryPort;

public class CreateUseCaseImp implements CreateBookUseCase {
    private  final BookRepositoryPort bookRepositoryPort;

    public CreateUseCaseImp(BookRepositoryPort bookRepository) {
        this.bookRepositoryPort = bookRepository;
    }

    @Override
    public Book createBook(Book book) {return  bookRepositoryPort.save(book);}
}
