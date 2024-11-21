package domain.ports.in.library;

import domain.models.Library;

public interface CreateLibraryUseCase {
    Library createLibrary(Library library);
}
