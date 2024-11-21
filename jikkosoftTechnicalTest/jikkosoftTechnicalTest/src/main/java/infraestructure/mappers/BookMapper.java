package infraestructure.mappers;

import domain.models.Book;
import domain.models.Library;
import infraestructure.Dto.in.BookDto;
import infraestructure.Dto.in.BookUpdateDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDto toCreationDto(Book book) {
        if (book == null) return null;

        return new BookDto(
                book.getBookName(),
                book.getBookName(),
                book.getBookGenre(),
                book.getAuthor(),
                book.getAvailable(),
                book.getLibrary() != null ? book.getLibrary().getLibraryID() : null
        );
    }

    public static List<BookDto> toBookCreationList(List<Book> books) {
        if (books == null) {
            return null;
        }

        return books.stream()
                .map(BookMapper::toCreationDto)
                .collect(Collectors.toList());
    }

    public static Book toBook(BookDto dto) {
        if (dto == null) {
            return null;
        }

        return new Book(
                null,
                dto.getBookCode(),
                dto.getBookName(),
                dto.getBookGenre(),
                dto.getAuthor(),
                new Library(dto.getLibrary()),
                dto.getAvailable(),
                null
        );
    }

    public static List<Book> toBookList(List<BookDto> dto) {
        if (dto == null) {
            return null;
        }

        return dto.stream()
                .map(BookMapper::toBook)
                .collect(Collectors.toList());
    }

    public static Book toBook(BookUpdateDto UpdateDTO) {
        if (UpdateDTO == null) {
            return null;
        }

        return new Book(
                UpdateDTO.getId(),
                UpdateDTO.getBookCode(),
                UpdateDTO.getBookName(),
                UpdateDTO.getBookGenre(),
                UpdateDTO.getAuthor(),
                new Library(UpdateDTO.getLibraryId()),
                UpdateDTO.getAvailable(),
                null
        );
    }
}
