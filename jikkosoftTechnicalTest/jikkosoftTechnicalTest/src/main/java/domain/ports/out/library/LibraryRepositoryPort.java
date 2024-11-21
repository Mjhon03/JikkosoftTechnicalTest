package domain.ports.out.library;

import domain.models.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepositoryPort {
    Library save(Library library);

    Optional<Library> findById(Integer LibraryId);

    List<Library> findAll();

    Optional<Library> update(Integer id, Library library);

    Boolean deleteById(Integer id);

}
