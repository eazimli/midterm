package ada.wm2.midterm.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RequestDto {

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String fistName;

    private String lastName;
}
