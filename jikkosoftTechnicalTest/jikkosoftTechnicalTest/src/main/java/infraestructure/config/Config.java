package infraestructure.config;

import application.services.BookReserveService;
import application.services.BookService;
import application.services.LibraryService;
import application.services.UserService;
import application.usecases.book.CreateUseCaseImp;
import application.usecases.book.DeleteUseCaseImp;
import application.usecases.book.GetUseCaseImp;
import application.usecases.book.UpdateUseCaseImp;
import application.usecases.bookReserve.CreateBookReserveUseCaseImp;
import application.usecases.bookReserve.DeleteBookReserveUseCaseImp;
import application.usecases.bookReserve.GetBookReserveUseCaseImp;
import application.usecases.bookReserve.UpdateBookReserveUseCaseImp;
import application.usecases.library.CreateLibraryUseCaseImp;
import application.usecases.library.DeleteLibraryUseCaseImp;
import application.usecases.library.GetLibraryUseCaseImp;
import application.usecases.library.UpdateLibraryUseCaseImp;
import application.usecases.user.CreateUserUseCaseImp;
import application.usecases.user.DeleteUserUseCaseImp;
import application.usecases.user.GetUserUseCaseImp;
import application.usecases.user.UpdateUserUseCaseImp;
import domain.ports.out.book.BookRepositoryPort;
import domain.ports.out.bookReserve.BookReverseRepositoryPort;
import domain.ports.out.library.LibraryRepositoryPort;
import domain.ports.out.user.UserRepositoryPort;
import infraestructure.repositories.Book.JpaBookAdapter;
import infraestructure.repositories.Book.JpaBookRepository;
import infraestructure.repositories.BookReserve.JpaBooReserveAdapter;
import infraestructure.repositories.BookReserve.JpaBookReserveRepository;
import infraestructure.repositories.Library.JpaLibraryAdapter;
import infraestructure.repositories.Library.JpaLibraryRepository;
import infraestructure.repositories.User.JpaUserAdapter;
import infraestructure.repositories.User.JpaUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserService userService(UserRepositoryPort userRepository) {
        return new UserService(
                new GetUserUseCaseImp(userRepository),
                new CreateUserUseCaseImp(userRepository),
                new UpdateUserUseCaseImp(userRepository),
                new DeleteUserUseCaseImp(userRepository)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserAdapter JpaUserAdapter) {
        return JpaUserAdapter;
    }

    @Bean
    public JpaUserAdapter JpaUserAdapter(JpaUserRepository JpaUserRepository) {
        return new JpaUserAdapter(JpaUserRepository);
    }

    @Bean
    public BookService bookService(BookRepositoryPort bookRepositoryPort){
        return new BookService(
                new GetUseCaseImp(bookRepositoryPort),
                new CreateUseCaseImp(bookRepositoryPort),
                new UpdateUseCaseImp(bookRepositoryPort),
                new DeleteUseCaseImp(bookRepositoryPort)
        );
    }

    @Bean
    public BookRepositoryPort bookRepositoryPort(JpaBookAdapter Adapter){
        return Adapter;
    }

    @Bean
    public JpaBookAdapter jpaBookRepositoryAdapter(JpaBookRepository jpaBookRepository){
        return new JpaBookAdapter(jpaBookRepository);
    }

    @Bean
    public LibraryService libraryService(LibraryRepositoryPort libraryRepositoryPort){
        return new LibraryService(
                new GetLibraryUseCaseImp(libraryRepositoryPort),
                new CreateLibraryUseCaseImp(libraryRepositoryPort),
                new UpdateLibraryUseCaseImp(libraryRepositoryPort),
                new DeleteLibraryUseCaseImp(libraryRepositoryPort)
        );
    }

    @Bean
    public LibraryRepositoryPort libraryRepositoryPort(JpaLibraryAdapter Adapter){
        return Adapter;
    }

    @Bean
    public JpaLibraryAdapter jpaLibraryRepositoryAdapter(JpaLibraryRepository jpaLibraryRepository){
        return new JpaLibraryAdapter(jpaLibraryRepository);
    }

    @Bean
    public BookReserveService bookReserveService(BookReverseRepositoryPort bookReserveRepositoryPort){
        return new BookReserveService(
                new GetBookReserveUseCaseImp(bookReserveRepositoryPort),
                new CreateBookReserveUseCaseImp(bookReserveRepositoryPort),
                new UpdateBookReserveUseCaseImp(bookReserveRepositoryPort),
                new DeleteBookReserveUseCaseImp(bookReserveRepositoryPort)
        );
    }

    @Bean
    public BookReverseRepositoryPort bookReserveRepositoryPort(JpaBooReserveAdapter Adapter){
        return Adapter;
    }

    @Bean
    public JpaBooReserveAdapter jpaBookReserveRepositoryAdapter(JpaBookReserveRepository jpaBookReserveRepository){
        return new JpaBooReserveAdapter(jpaBookReserveRepository);
    }
}
