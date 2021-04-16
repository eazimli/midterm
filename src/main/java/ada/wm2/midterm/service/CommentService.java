package ada.wm2.midterm.service;

import ada.wm2.midterm.entity.Comment;
import ada.wm2.midterm.model.CommentDto;
import ada.wm2.midterm.model.ReplyDto;
import ada.wm2.midterm.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentByBookId(Long id) {
        return commentRepository.findAllByBookId(id);
    }

    public ResponseEntity<String> comment(CommentDto dto) {
        String author = dto.getAuthor();
        Long bookId = dto.getBookId();
        String comment = dto.getComment();

        Comment commentFromUser = new Comment(bookId, author, comment);
        commentRepository.save(commentFromUser);
        return new ResponseEntity<>("comment added", HttpStatus.OK);
    }

    public ResponseEntity<String> reply(ReplyDto dto) {

        String commentId = dto.getCommentId();
        String reply = dto.getReply();
        String author = dto.getAuthor();
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment newReply = new Comment(author, reply);
            List<Comment> list = new ArrayList<>();
            list.add(newReply);
            comment.get().setReplies(list);
        }
        commentRepository.save(comment.get());
        return new ResponseEntity<>("reply added", HttpStatus.OK);

    }
}
