package ada.wm2.midterm.service;

import ada.wm2.midterm.entity.Book;
import ada.wm2.midterm.entity.Category;
import ada.wm2.midterm.entity.Comment;
import ada.wm2.midterm.mapper.BookMapper;
import ada.wm2.midterm.mapper.CommentMapper;
import ada.wm2.midterm.model.BookModel;
import ada.wm2.midterm.model.CommentResponse;
import ada.wm2.midterm.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final CommentMapper commentMapper;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CommentService  commentService;
    public BookService(CommentMapper commentMapper, BookRepository bookRepository,
                       BookMapper bookMapper, CommentService commentService) {
        this.commentMapper = commentMapper;
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.commentService = commentService;
    }

    public Book find(Book book) {
        final String name = book.getName();
        final String author = book.getAuthor();
        final Category category = book.getCategory();
        return bookRepository.findByNameOrAuthorOrCategory(name, author, category)
                .orElseThrow(RuntimeException::new);
    }

    public ResponseEntity<BookModel> getById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        List<CommentResponse> comments=commentMapper.toDTOS(commentService.getCommentByBookId(id));
        BookModel bookModel=bookMapper.toDto(book);
        bookModel.setComments(comments);
        return new ResponseEntity<>(bookModel, HttpStatus.OK);
    }
}
