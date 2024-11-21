package application.usecases.book;

import domain.models.Book;
import domain.ports.in.book.CreateBookUseCase;
import domain.ports.out.book.BookRepositoryPort;

public class CreateUseCaseImp implements CreateBookUseCase {
    private  final BookRepositoryPort bookRepositoryPort;

    public CreateUseCaseImp(BookRepositoryPort bookRepository) {
        this.bookRepositoryPort = bookRepository;
    }

    @Override
    public Book createBook(Book book) {return  bookRepositoryPort.save(book);}
}
