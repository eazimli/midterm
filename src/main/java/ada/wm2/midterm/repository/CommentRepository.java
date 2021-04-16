package ada.wm2.midterm.repository;

import ada.wm2.midterm.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String> {

    List<Comment> findAllByBookId(Long bookId);
}
