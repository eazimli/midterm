package ada.wm2.midterm.model;

import ada.wm2.midterm.entity.Category;
import ada.wm2.midterm.entity.Comment;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class BookModel {

    private Long id;

    private String name;

    private String author;

    private String edition;

    private Long price;

    private Category category;

 private List<CommentResponse> comments;


}
