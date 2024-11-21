package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.library;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;

import java.util.List;
import java.util.Optional;

public interface GetLibraryUseCase {
    Optional<Library> getLibraryById(Integer id);

    List<Library> getAllLibraries();

}
