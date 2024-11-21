package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;

public interface CreateBookUseCase {
    Book createBook(Book book);
}
