package TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.Library;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.library.LibraryRepositoryPort;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.LibraryEntity;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers.LibraryMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaLibraryAdapter implements LibraryRepositoryPort {

    private final JpaLibraryRepository libraryRepository;

    @Override
    public Library save(Library library) {
        LibraryEntity libraryEntity = LibraryMapper.fromDomainModel(library);
        return libraryRepository.save(libraryEntity).toDomainModel();
    }

    @Override
    public Optional<Library> findById(Integer LibraryId) {
        return libraryRepository.findById(Long.valueOf(LibraryId)).map(LibraryEntity::toDomainModel);
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll().stream()
                .map(LibraryEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Library> update(Integer id, Library library) {
        if(libraryRepository.existsById(Long.valueOf(library.getLibraryID()))){
            LibraryEntity updatedLibraryEntity = libraryRepository.save(LibraryMapper.fromDomainModel(library));
            return Optional.of(updatedLibraryEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(libraryRepository.existsById(Long.valueOf(id))){
            libraryRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }
}
