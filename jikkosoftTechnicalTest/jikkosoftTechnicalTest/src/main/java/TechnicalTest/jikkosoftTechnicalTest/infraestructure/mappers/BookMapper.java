package TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.BookDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.BookUpdateDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out.BookOutputDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.BookEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.BookEntity.fromDomainModel;

public class BookMapper {


    public static List<Book> toDomainModelList(List<BookEntity> bookEntityList){
        List<Book> bookList = new ArrayList<>();
        for (BookEntity bookEntity: bookEntityList){
            bookList.add(bookEntity.toDomainModel());
        }
        return bookList;
    }


    public static List<BookEntity> fromDomainModelList(List<Book> bookList){
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (Book book: bookList){
            bookEntityList.add(fromDomainModel(book));
        }
        return bookEntityList;
    }


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

    public static BookOutputDto toOutputDto(Book book) {
        if (book == null) {
            return null;
        }

        return new BookOutputDto(
                book.getId(),
                book.getBookCode(),
                book.getBookName(),
                book.getBookGenre(),
                book.getAuthor(),
                book.getAvailable(),
                book.getLibrary() != null ? book.getLibrary().getLibraryID() : null,
                book.getReservedBooks() != null
                        ? book.getReservedBooks().stream()
                        .map(BookReserve::getId)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }

    public static List<BookOutputDto> toOutputDtoList(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return Collections.emptyList();
        }

        return books.stream()
                .map(BookMapper::toOutputDto)
                .collect(Collectors.toList());
    }
}
