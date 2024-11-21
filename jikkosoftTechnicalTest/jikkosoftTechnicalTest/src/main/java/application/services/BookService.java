package application.services;

import domain.models.Book;
import domain.ports.in.book.CreateBookUseCase;
import domain.ports.in.book.DeleteBookUseCase;
import domain.ports.in.book.GetBookUseCase;
import domain.ports.in.book.UpdateBookUseCase;

import java.util.List;
import java.util.Optional;

public class BookService implements GetBookUseCase, CreateBookUseCase, UpdateBookUseCase, DeleteBookUseCase {
    private final GetBookUseCase getBookUseCase ;
    private final CreateBookUseCase createBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;

    public BookService(GetBookUseCase getBookUseCase, CreateBookUseCase createBookUseCase, UpdateBookUseCase updateBookUseCase , DeleteBookUseCase deleteBookUseCase) {
        this.getBookUseCase = getBookUseCase;
        this.createBookUseCase = createBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
    }

    @Override
    public List<Book> getAllBooks() {
        return getBookUseCase.getAllBooks();
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return getBookUseCase.getBookById(id);
    }

    @Override
    public Book createBook(Book book) {
        return createBookUseCase.createBook(book);
    }

    @Override
    public Boolean deleteBookById(Integer id) {
        return deleteBookUseCase.deleteBookById(id);
    }

    @Override
    public Optional<Book> updateBook(Integer id, Book book) {
        return updateBookUseCase.updateBook(id, book);
    }


}
