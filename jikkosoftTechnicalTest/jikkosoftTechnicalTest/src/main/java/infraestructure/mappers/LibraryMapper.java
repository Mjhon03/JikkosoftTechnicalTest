package infraestructure.mappers;

import domain.models.Library;
import infraestructure.Dto.in.LibraryDto;
import java.util.stream.Collectors;
import java.util.List;

public class LibraryMapper {

    public static LibraryDto toLibraryCreationDTO(Library library) {
        if (library == null) {
            return null;
        }

        return new LibraryDto(
                library.getName(),
                library.getActive()
        );
    }

    public static List<LibraryDto> toLibraryDtoList(List<Library> libraries) {
        if (libraries == null) {
            return null;
        }

        return libraries.stream()
                .map(LibraryMapper::toLibraryCreationDTO)
                .collect(Collectors.toList());
    }

    public static Library toLibrary(LibraryDto dto) {
        if (dto == null) {
            return null;
        }

        return new Library(
                null, // LibraryID será nulo porque LibraryDto no lo incluye
                dto.getName(),
                dto.getActive(),
                null // Books no está en el LibraryDto
        );
    }

    public static List<Library> toLibraryList(List<LibraryDto> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(LibraryMapper::toLibrary)
                .collect(Collectors.toList());
    }

}
