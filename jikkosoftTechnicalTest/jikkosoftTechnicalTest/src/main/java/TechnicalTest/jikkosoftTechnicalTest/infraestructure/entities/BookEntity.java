package TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers.LibraryMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Book")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "bookCode", nullable = false, unique = true)
    private String bookCode;

    @Column(name = "bookName", nullable = false)
    private String bookName;

    @Column(name = "bookGenre", nullable = false)
    private String bookGenre;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "available")
    private Boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libraryId")
    private LibraryEntity library;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookReserveEntity>  reservedBooks;


    public static BookEntity fromDomainModel(Book book){
        return new BookEntity(book.getId(),
                book.getBookCode(),
                book.getBookName(),
                book.getBookGenre(),
                book.getAuthor(),
                book.getAvailable(),
                book.getLibrary() != null ? LibraryMapper.fromDomainModel(book.getLibrary()) : null,
                book.getReservedBooks() != null ? BookReserveEntity.fromDomainModelList(book.getReservedBooks()) : new ArrayList<>()
        );
    }

    public Book toDomainModel(){
        return new Book(this.id, this.bookCode, this.bookName, this.bookGenre, this.author, null ,this.available, null);
    }
}
