package application.usecases.library;

import domain.models.Library;
import domain.ports.in.library.UpdateLibraryUseCase;
import domain.ports.out.library.LibraryRepositoryPort;

import java.util.Optional;

public class UpdateLibraryUseCaseImp implements UpdateLibraryUseCase {

    private final LibraryRepositoryPort libraryRepositoryPort;

    public UpdateLibraryUseCaseImp(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }


    @Override
    public Optional<Library> updateLibrary(Integer id, Library library) {
        return libraryRepositoryPort.update(id, library);
    }
}
