package application.usecases.library;

import domain.ports.in.library.DeleteLibraryUseCase;
import domain.ports.out.library.LibraryRepositoryPort;

public class DeleteLibraryUseCaseImp implements DeleteLibraryUseCase {
    private final LibraryRepositoryPort libraryRepositoryPort;

    public DeleteLibraryUseCaseImp(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }


    @Override
    public Boolean deleteLibraryById(Integer id) {
        return libraryRepositoryPort.deleteById(id);
    }
}
