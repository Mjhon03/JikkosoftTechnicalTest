package TechnicalTest.jikkosoftTechnicalTest.infraestructure.controllers;

import TechnicalTest.jikkosoftTechnicalTest.application.services.BookService;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.BookDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.BookUpdateDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers.BookMapper;
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
@RequestMapping("book/")
@AllArgsConstructor
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> findAllBook(){
        List<Book> bookReserveList = new ArrayList<>();
        try{
            bookReserveList = bookService.getAllBooks();
        } catch(Exception e){
            log.error("Failed: find all books", e);
        }
        return new ResponseEntity<>(bookReserveList, HttpStatus.OK);
    }

    @GetMapping("/{BookId}")
    public ResponseEntity<Book> findBook(@RequestParam Integer libraryId){
        Book book = new Book();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<Book> optBook= bookService.getBookById(libraryId);
            if (optBook.isPresent()){
                book = optBook.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: find book by id", e);
        }
        return new ResponseEntity<>(book, status);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto book){
        Book newBook = new Book();
        try{
            newBook = bookService.createBook(BookMapper.toBook(book));
        } catch (Exception e){
            log.error("Failed: create book", e);
        }
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody BookUpdateDto book){
        Book updatedBook = new Book();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<Book> optBook = bookService.updateBook(book.getId(), BookMapper.toBook(book));
            if(optBook.isPresent()){
                updatedBook = optBook.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: update book", e);
        }

        return new ResponseEntity<>(updatedBook, status);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Integer bookId){
        try{
            bookService.getBookById(bookId);
        } catch(Exception e){
            log.error("Failed: delete book", e);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
