package TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.Library;

import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLibraryRepository extends JpaRepository<LibraryEntity, Long> {
}