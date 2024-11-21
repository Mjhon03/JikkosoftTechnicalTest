package infraestructure.Dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookUpdateDto {
    private Integer id;
    private String bookCode;
    private String bookName;
    private String bookGenre;
    private String author;
    private Boolean Available;
    private Integer libraryId;
}
