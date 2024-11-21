package TechnicalTest.jikkosoftTechnicalTest.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Library {
    private Integer LibraryID;
    private String Name;
    private Boolean Active;
    private List<Book> Books;

    public Library(Integer LibraryId) {
        this.LibraryID = LibraryId;
    }
}
