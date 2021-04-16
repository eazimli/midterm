package ada.wm2.midterm.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CommentDto {

    @NotNull
    Long bookId;

    @NotNull
    String comment;

    @NotNull
    String author;
}
