package ada.wm2.midterm.repository;

import ada.wm2.midterm.entity.Book;
import ada.wm2.midterm.entity.Category;
import ada.wm2.midterm.model.Available;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "books", path = "books")
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByAvailableAndId(Available available, Long id);

    Optional<Book> findByNameOrAuthorOrCategory(String name, String author, Category category);

    Optional<Book> findByNameAndAuthor(String name, String author);

    Optional<Book> findByAuthorAndCategory(String author, Category category);
}
