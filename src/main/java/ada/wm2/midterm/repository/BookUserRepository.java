package ada.wm2.midterm.repository;

import ada.wm2.midterm.entity.Book;
import ada.wm2.midterm.entity.BookUser;
import ada.wm2.midterm.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(collectionResourceRel = "bookUsers", path = "bookUsers")
public interface BookUserRepository extends JpaRepository<BookUser,Long> {
    Optional<BookUser> findByBookAndUser(Book book, Users user);

    List<BookUser> findAllByUser(Users user);

    Long removeBookUserByBookAndUser(Book book,Users user);


}
