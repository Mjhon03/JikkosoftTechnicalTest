package TechnicalTest.jikkosoftTechnicalTest.infraestructure.config;

import TechnicalTest.jikkosoftTechnicalTest.application.services.BookReserveService;
import TechnicalTest.jikkosoftTechnicalTest.application.services.BookService;
import TechnicalTest.jikkosoftTechnicalTest.application.services.LibraryService;
import TechnicalTest.jikkosoftTechnicalTest.application.services.UserService;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.book.CreateUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.book.DeleteUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.book.GetUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.book.UpdateUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve.CreateBookReserveUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve.DeleteBookReserveUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve.GetBookReserveUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve.UpdateBookReserveUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.library.CreateLibraryUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.library.DeleteLibraryUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.library.GetLibraryUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.library.UpdateLibraryUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.user.CreateUserUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.user.DeleteUserUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.user.GetUserUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.application.usecases.user.UpdateUserUseCaseImp;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.book.BookRepositoryPort;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.bookReserve.BookReverseRepositoryPort;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.library.LibraryRepositoryPort;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.user.UserRepositoryPort;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.Book.JpaBookAdapter;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.Book.JpaBookRepository;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.BookReserve.JpaBooReserveAdapter;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.BookReserve.JpaBookReserveRepository;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.Library.JpaLibraryAdapter;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.Library.JpaLibraryRepository;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.User.JpaUserAdapter;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.User.JpaUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(
                new GetUserUseCaseImp(userRepositoryPort),
                new CreateUserUseCaseImp(userRepositoryPort),
                new UpdateUserUseCaseImp(userRepositoryPort),
                new DeleteUserUseCaseImp(userRepositoryPort)
        );
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
    public LibraryService libraryService(LibraryRepositoryPort libraryRepositoryPort){
        return new LibraryService(
                new GetLibraryUseCaseImp(libraryRepositoryPort),
                new CreateLibraryUseCaseImp(libraryRepositoryPort),
                new UpdateLibraryUseCaseImp(libraryRepositoryPort),
                new DeleteLibraryUseCaseImp(libraryRepositoryPort)
        );
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
    public UserRepositoryPort userRepositoryPort(JpaUserAdapter JpaUserAdapter) {
        return JpaUserAdapter;
    }



    @Bean
    public BookRepositoryPort bookRepositoryPort(JpaBookAdapter Adapter){
        return Adapter;
    }



    @Bean
    public LibraryRepositoryPort libraryRepositoryPort(JpaLibraryAdapter Adapter){
        return Adapter;
    }


    @Bean
    public BookReverseRepositoryPort bookReserveRepositoryPort(JpaBooReserveAdapter Adapter){
        return Adapter;
    }

    @Bean
    public JpaUserAdapter jpaUserAdapter(JpaUserRepository jpaUserRepository) {
        return new JpaUserAdapter(jpaUserRepository);
    }

    @Bean
    public JpaBookAdapter jpaBookRepositoryAdapter(JpaBookRepository jpaBookRepository){
        return new JpaBookAdapter(jpaBookRepository);
    }

    @Bean
    public JpaLibraryAdapter jpaLibraryRepositoryAdapter(JpaLibraryRepository jpaLibraryRepository){
        return new JpaLibraryAdapter(jpaLibraryRepository);
    }

    @Bean
    public JpaBooReserveAdapter jpaBookReserveRepositoryAdapter(JpaBookReserveRepository jpaBookReserveRepository){
        return new JpaBooReserveAdapter(jpaBookReserveRepository);
    }
}
