package application.usecases.library;

import domain.models.Library;
import domain.ports.in.library.GetLibraryUseCase;
import domain.ports.out.library.LibraryRepositoryPort;

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
