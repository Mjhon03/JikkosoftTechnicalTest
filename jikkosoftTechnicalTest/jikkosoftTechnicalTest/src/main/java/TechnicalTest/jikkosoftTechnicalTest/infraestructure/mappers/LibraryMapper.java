package TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.LibraryDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out.LibraryOutputDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.LibraryEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;

public class LibraryMapper {




    public static LibraryEntity fromDomainModel(Library library){
        return new LibraryEntity(library.getLibraryID(),
                library.getName(),
                library.getActive(),
                library.getBooks() != null ?BookMapper.fromDomainModelList(library.getBooks()) : new ArrayList<>()
        );
    }

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

    public static LibraryOutputDto toOutputDto(Library library) {
        if (library == null) {
            return null;
        }

        return new LibraryOutputDto(
                library.getLibraryID(),
                library.getName(),
                library.getActive(),
                library.getBooks() != null
                        ? library.getBooks().stream()
                        .map(Book::getId) // Convertimos los libros a sus IDs
                        .collect(Collectors.toList())
                        : Collections.emptyList() // Lista vacía si no hay libros
        );
    }


    public static List<LibraryOutputDto> toOutputDtoList(List<Library> libraries) {
        if (libraries == null || libraries.isEmpty()) {
            return Collections.emptyList();
        }

        return libraries.stream()
                .map(LibraryMapper::toOutputDto)
                .collect(Collectors.toList());
    }
}
