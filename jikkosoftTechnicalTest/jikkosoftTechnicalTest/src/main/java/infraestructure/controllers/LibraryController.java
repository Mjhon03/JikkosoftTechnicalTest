package infraestructure.controllers;

import application.services.LibraryService;
import domain.models.Library;
import infraestructure.Dto.in.LibraryDto;
import infraestructure.mappers.LibraryMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("library/")
@AllArgsConstructor
public class LibraryController {

    private static final Logger log = LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService libraryService;

    @GetMapping("/{libraryId}")
    public ResponseEntity<Library> findLibrary(@RequestParam Integer libraryId){
        Library library = new Library();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<Library> optLibrary= libraryService.getLibraryById(libraryId);
            if (optLibrary.isPresent()){
                library = optLibrary.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: find library by id", e);
        }
        return new ResponseEntity<>(library, status);
    }

    @GetMapping
    public ResponseEntity<List<Library>> findAllUsers(){
        List<Library> libraryList = new ArrayList<>();
        try{
            libraryList = libraryService.getAllLibraries();
        } catch(Exception e){
            log.error("Failed: find all library", e);
        }
        return new ResponseEntity<>(libraryList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody LibraryDto library){
        Library newLibrary = new Library();
        try{
            newLibrary = libraryService.createLibrary(LibraryMapper.toLibrary(library));
        } catch (Exception e){
            log.error("Failed: create library", e);
        }
        return new ResponseEntity<>(newLibrary, HttpStatus.CREATED);
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer libraryId){
        try{
            libraryService.deleteLibraryById(libraryId);
        } catch(Exception e){
            log.error("Failed: delete library", e);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
