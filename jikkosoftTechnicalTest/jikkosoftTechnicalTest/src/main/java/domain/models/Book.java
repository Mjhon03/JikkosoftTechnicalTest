package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    private Integer id;
    private String bookCode;
    private String bookName;
    private String bookGenre;
    private String author;
    private Library library;
    private Boolean Available;
    private List<BookReserve> reservedBooks;

    public Book(Integer bookId){
        this.id = bookId;
    }

}
