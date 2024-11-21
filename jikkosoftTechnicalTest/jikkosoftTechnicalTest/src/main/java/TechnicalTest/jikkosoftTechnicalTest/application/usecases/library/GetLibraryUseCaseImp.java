package TechnicalTest.jikkosoftTechnicalTest.application.usecases.library;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.library.GetLibraryUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.library.LibraryRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GetLibraryUseCaseImp implements GetLibraryUseCase {

    private final LibraryRepositoryPort libraryRepositoryPort;

    public GetLibraryUseCaseImp(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }


    @Override
    public Optional<Library> getLibraryById(Integer id) {
        return libraryRepositoryPort.findById(id);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryRepositoryPort.findAll();
    }
}
