package TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Library;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers.BookMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Library")
@AllArgsConstructor
@NoArgsConstructor
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LibraryID", updatable = false, nullable = false)
    private Integer LibraryID;

    @Column(name="Name")
    private String Name;

    @Column(name="Active")
    private Boolean Active;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<BookEntity> bookList;


    public Library toDomainModel(){
        return new Library(this.LibraryID, this.Name, this.Active, BookMapper.toDomainModelList(this.bookList));
    }


}
