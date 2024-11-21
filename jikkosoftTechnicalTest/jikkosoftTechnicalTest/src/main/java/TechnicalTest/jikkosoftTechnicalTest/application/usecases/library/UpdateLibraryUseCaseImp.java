package TechnicalTest.jikkosoftTechnicalTest.application.usecases.library;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.library.UpdateLibraryUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.library.LibraryRepositoryPort;

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
