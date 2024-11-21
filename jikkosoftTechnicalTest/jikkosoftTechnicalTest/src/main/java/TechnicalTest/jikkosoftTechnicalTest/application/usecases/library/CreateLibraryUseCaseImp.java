package TechnicalTest.jikkosoftTechnicalTest.application.usecases.library;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.library.CreateLibraryUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.library.LibraryRepositoryPort;

public class CreateLibraryUseCaseImp implements CreateLibraryUseCase {

    private final LibraryRepositoryPort libraryRepositoryPort;

    public CreateLibraryUseCaseImp(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }


    @Override
    public Library createLibrary(Library library) {
        return libraryRepositoryPort.save(library);
    }
}
