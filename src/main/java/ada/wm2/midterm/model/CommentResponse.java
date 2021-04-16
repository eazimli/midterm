package ada.wm2.midterm.model;

import ada.wm2.midterm.entity.Comment;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CommentResponse {

    private String id;

    private String author;

    private String comment;

    private List<CommentResponse> replies;

}
