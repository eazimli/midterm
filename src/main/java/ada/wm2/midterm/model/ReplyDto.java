package ada.wm2.midterm.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ReplyDto {

    @NotNull
    String commentId;

    @NotNull
    String author;

    @NotNull
    String reply;
}
