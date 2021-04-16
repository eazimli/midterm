package ada.wm2.midterm.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class BookUserDto {
    @NotNull
    private Long bookId;

    private Long userId;
}
