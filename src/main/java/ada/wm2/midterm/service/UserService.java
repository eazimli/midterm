package ada.wm2.midterm.service;


import ada.wm2.midterm.entity.Book;
import ada.wm2.midterm.entity.BookUser;
import ada.wm2.midterm.entity.Users;
import ada.wm2.midterm.model.Available;
import ada.wm2.midterm.model.BookUserDto;
import ada.wm2.midterm.model.Status;
import ada.wm2.midterm.repository.BookRepository;
import ada.wm2.midterm.repository.BookUserRepository;
import ada.wm2.midterm.repository.RegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    private final BookRepository bookRepository;
    private final RegistrationRepository registrationRepository;
    private final BookUserRepository bookUserRepository;
    private final RegistrationService registrationService;


    public UserService(BookRepository bookRepository,
                       RegistrationRepository registrationRepository, BookUserRepository bookUserRepository,
                       RegistrationService registrationService) {
        this.bookRepository = bookRepository;
        this.registrationRepository = registrationRepository;
        this.bookUserRepository = bookUserRepository;
        this.registrationService = registrationService;
    }

    public Status create(BookUserDto dto, HttpSession session) {
        final Long bookId = dto.getBookId();
        Book book = bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
        final String email = (String) session.getAttribute("email");
        Users userFromSession = registrationService.findByEmail(email);
        if (userFromSession != null && bookIsAvailable(bookId, Available.YES)) {
            bookUserRepository.save(new BookUser(book, userFromSession));
        } else {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

    boolean bookIsAvailable(Long id, Available available) {
        return bookRepository.findByAvailableAndId(available, id).isPresent();
    }

    @Transactional
    public Status drop(BookUserDto dto, HttpSession session) {
        final Long bookId = dto.getBookId();
        Book book = bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
        final String email = (String) session.getAttribute("email");
        Users userFromSession = registrationService.findByEmail(email);

        if (userFromSession != null && bookIsAvailable(bookId, Available.NO)) {
            bookUserRepository.removeBookUserByBookAndUser(book, userFromSession);
            book.setAvailable(Available.YES);
            bookRepository.save(book);
        } else {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

    public List<BookUser> all(HttpSession session) {
        final String email = (String) session.getAttribute("email");
        Users userFromSession = registrationService.findByEmail(email);
        return bookUserRepository.findAllByUser(userFromSession);
    }
}
