package application.usecases.library;

import domain.models.Library;
import domain.ports.in.library.CreateLibraryUseCase;
import domain.ports.out.library.LibraryRepositoryPort;

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
