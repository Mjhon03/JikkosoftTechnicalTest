package TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class LibraryOutputDto {
    private Integer libraryId;
    private String name;
    private Boolean active;
    private List<Integer> bookIds;
}