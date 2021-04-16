package ada.wm2.midterm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Long bookId;

    private String author;

    private String comment;

    @OneToMany
    private List<Comment> replies;

    public Comment(Long bookId, String author, String comment) {
        this.bookId = bookId;
        this.author = author;
        this.comment = comment;
    }

    public Comment(String author, String comment) {
        this.author = author;
        this.comment = comment;
    }
}
