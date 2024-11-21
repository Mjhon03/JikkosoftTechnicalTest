package TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.library;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepositoryPort {
    Library save(Library library);

    Optional<Library> findById(Integer LibraryId);

    List<Library> findAll();

    Optional<Library> update(Integer id, Library library);

    Boolean deleteById(Integer id);

}
