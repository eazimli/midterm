package ada.wm2.midterm.controller;

import ada.wm2.midterm.entity.Book;
import ada.wm2.midterm.model.BookModel;
import ada.wm2.midterm.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<Book> getBook(@RequestBody Book book) {
        logger.info("requested book " + book.getName() + " " + book.getAuthor() + " " + book.getCategory());
        return new ResponseEntity<>(bookService.find(book), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

}
