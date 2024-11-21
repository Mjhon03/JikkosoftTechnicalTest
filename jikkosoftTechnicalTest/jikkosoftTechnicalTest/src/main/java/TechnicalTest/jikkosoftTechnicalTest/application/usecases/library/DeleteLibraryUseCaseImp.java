package TechnicalTest.jikkosoftTechnicalTest.application.usecases.library;

import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.library.DeleteLibraryUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.library.LibraryRepositoryPort;

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
