package TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BookOutputDto {
    private Integer id;
    private String bookCode;
    private String bookName;
    private String bookGenre;
    private String author;
    private Boolean available;
    private Integer libraryId;
    private List<Integer> reservedBookIds;
}
