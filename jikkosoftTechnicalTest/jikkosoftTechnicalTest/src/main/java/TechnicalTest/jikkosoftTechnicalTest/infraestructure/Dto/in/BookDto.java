package TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookDto {
    private String bookCode;
    private String bookName;
    private String bookGenre;
    private String author;
    private Boolean Available;
    private Integer library;
}
