package infraestructure.repositories.Library;

import infraestructure.entities.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLibraryRepository extends JpaRepository<LibraryEntity, Long> {
}