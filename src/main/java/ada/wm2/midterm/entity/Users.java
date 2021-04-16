package ada.wm2.midterm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Users_sequence")
    @SequenceGenerator(name = "Users_sequence", sequenceName = "Users_sequence", allocationSize = 1)
    private Long id;

    private String fistName;

    private String lastName;

    @Column(nullable = false, unique = true, updatable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<BookUser> bookUser;

    public Users(String fistName, String lastName, String email, String password) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}