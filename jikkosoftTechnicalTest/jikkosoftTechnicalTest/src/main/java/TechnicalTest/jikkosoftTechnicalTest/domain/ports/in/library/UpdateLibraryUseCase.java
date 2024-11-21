package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.library;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;

import java.util.Optional;

public interface UpdateLibraryUseCase {
    Optional<Library> updateLibrary(Integer id, Library library);

}
