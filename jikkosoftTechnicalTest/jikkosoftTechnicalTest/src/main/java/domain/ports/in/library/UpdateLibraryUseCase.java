package domain.ports.in.library;

import domain.models.Library;

import java.util.Optional;

public interface UpdateLibraryUseCase {
    Optional<Library> updateLibrary(Integer id, Library library);

}
