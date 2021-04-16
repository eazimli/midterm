package ada.wm2.midterm.entity;

import ada.wm2.midterm.model.Available;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Book_sequence")
    @SequenceGenerator(name = "Book_sequence", sequenceName = "Book_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String author;

    private String edition;

    private Long price;

    @Enumerated(EnumType.STRING)
    private Available available = Available.YES;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookUser> bookUser;

    public Book(String name, String author, String edition, Long price, Category category) {
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.category = category;
    }

    public Book() {
    }

}
