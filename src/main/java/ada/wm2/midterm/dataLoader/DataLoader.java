package ada.wm2.midterm.dataLoader;

import ada.wm2.midterm.entity.Book;
import ada.wm2.midterm.entity.Category;
import ada.wm2.midterm.entity.Comment;
import ada.wm2.midterm.entity.Users;
import ada.wm2.midterm.model.Categories;
import ada.wm2.midterm.repository.BookRepository;
import ada.wm2.midterm.repository.CategoryRepository;
import ada.wm2.midterm.repository.CommentRepository;
import ada.wm2.midterm.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoader {
    private final CategoryRepository categoryRepository;
    private RegistrationRepository registrationRepository;
    private BookRepository bookRepository;
   private final CommentRepository commentRepository;
    public DataLoader(CategoryRepository categoryRepository, RegistrationRepository registrationRepository,
                      BookRepository bookRepository, CommentRepository commentRepository) {
        this.categoryRepository = categoryRepository;
        this.registrationRepository = registrationRepository;
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    @PostConstruct
    private void loadData() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(Categories.Action));
        categories.add(new Category(Categories.Adventure));
        categories.add(new Category(Categories.Comedy));
        categories.add(new Category(Categories.Crime));
        categories.add(new Category(Categories.Drama));
        categories.add(new Category(Categories.Fantasy));
        categories.add(new Category(Categories.Romance));
        categories.add(new Category(Categories.Horror));
        categories.add(new Category(Categories.Historical));
        categoryRepository.saveAll(categories);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Hamlet", "William Shakespeare", "first", 20l,
                categoryRepository.getOne(6l)));
        books.add(new Book("The Sound and the Fury", "William Faulkner", "second", 30l,
                categoryRepository.getOne(8l)));
        books.add(new Book("Sekkizinci Gun", "'Keramet Boyukcol", "first", 5l,
                categoryRepository.getOne(5l)));
        books.add(new Book("Daisy Miller", "Henry James", "first", 35l,
                categoryRepository.getOne(7l)));
        books.add(new Book("Emma", "Jane Austen", "first", 20l,
                categoryRepository.getOne(9l)));
        books.add(new Book("Oliver Twist", "Charles Dickens", "first", 20l,
                categoryRepository.getOne(3l)));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", "first", 20l,
                categoryRepository.getOne(4l)));
        books.add(new Book("Death in the afternoon", "Ernest Hemingway", "first", 20l,
                categoryRepository.getOne(1l)));
        bookRepository.saveAll(books);

        registrationRepository.save(new Users("Elcan", "Azimli", "eazimli2021@ada.edu.az",
                "qwerty"));

    }


}
