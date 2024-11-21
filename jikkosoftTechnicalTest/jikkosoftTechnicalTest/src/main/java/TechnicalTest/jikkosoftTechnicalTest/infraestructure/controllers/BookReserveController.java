package TechnicalTest.jikkosoftTechnicalTest.infraestructure.controllers;

import TechnicalTest.jikkosoftTechnicalTest.application.services.BookReserveService;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.BookReserveDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers.BookReserveMapper;
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
@RequestMapping("bookReserve/")
@AllArgsConstructor
public class BookReserveController {
    private BookReserveService bookReserveService;
    private static final Logger log = LoggerFactory.getLogger(BookReserveController.class);

    @GetMapping
    public ResponseEntity<List<BookReserve>> findAllBookReserves(){
        List<BookReserve> bookReserveList = new ArrayList<>();
        try{
            bookReserveList = bookReserveService.getAllBookReserves();
        } catch(Exception e){
            log.error("Failed: find all book reserves", e);
        }
        return new ResponseEntity<>(bookReserveList, HttpStatus.OK);
    }

    @GetMapping("/{bookReserveId}")
    public ResponseEntity<BookReserve> findBookReserve(@RequestParam Integer bookReserveId){
        BookReserve bookReserve = new BookReserve();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<BookReserve> optBookReserve= bookReserveService.getBookReserveById(bookReserveId);
            if (optBookReserve.isPresent()){
                bookReserve = optBookReserve.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: find bookReserve by id", e);
        }
        return new ResponseEntity<>(bookReserve, status);
    }


    @PostMapping
    public ResponseEntity<BookReserve> createBookReserve(@RequestBody BookReserveDto book){
        BookReserve newBookReserve = new BookReserve();
        try{
            newBookReserve = bookReserveService.createBookReserve(BookReserveMapper.toBookReserve(book));
        } catch (Exception e){
            log.error("Failed: create book reserve", e);
        }
        return new ResponseEntity<>(newBookReserve, HttpStatus.CREATED);
    }

}
