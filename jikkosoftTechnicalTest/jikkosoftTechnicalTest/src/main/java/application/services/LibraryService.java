package application.services;

import domain.models.Library;
import domain.ports.in.library.CreateLibraryUseCase;
import domain.ports.in.library.DeleteLibraryUseCase;
import domain.ports.in.library.GetLibraryUseCase;
import domain.ports.in.library.UpdateLibraryUseCase;

import java.util.List;
import java.util.Optional;

public class LibraryService implements GetLibraryUseCase, CreateLibraryUseCase, UpdateLibraryUseCase, DeleteLibraryUseCase {

    private final GetLibraryUseCase getLibraryUseCase;
    private final CreateLibraryUseCase createLibraryUseCase;
    private final UpdateLibraryUseCase updateLibraryUseCase;
    private final DeleteLibraryUseCase deleteLibraryUseCase;

    public LibraryService(GetLibraryUseCase getLibraryUseCase, CreateLibraryUseCase createLibraryUseCase, UpdateLibraryUseCase updateLibraryUseCase, DeleteLibraryUseCase deleteLibraryUseCase) {
        this.getLibraryUseCase = getLibraryUseCase;
        this.createLibraryUseCase = createLibraryUseCase;
        this.updateLibraryUseCase = updateLibraryUseCase;
        this.deleteLibraryUseCase = deleteLibraryUseCase;
    }

    @Override
    public Library createLibrary(Library library) {
        return createLibraryUseCase.createLibrary(library);
    }

    @Override
    public Boolean deleteLibraryById(Integer id) {
        return deleteLibraryUseCase.deleteLibraryById(id);
    }

    @Override
    public Optional<Library> getLibraryById(Integer id) {
        return getLibraryUseCase.getLibraryById(id);
    }

    @Override
    public List<Library> getAllLibraries() {
        return getLibraryUseCase.getAllLibraries();
    }

    @Override
    public Optional<Library> updateLibrary(Integer id, Library library) {
        return updateLibraryUseCase.updateLibrary(id, library);
    }
}
