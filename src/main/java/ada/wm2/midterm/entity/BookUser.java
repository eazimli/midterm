package ada.wm2.midterm.entity;

import ada.wm2.midterm.model.Available;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;


@Data
@Entity
public class BookUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BookUser_sequence")
    @SequenceGenerator(name = "BookUser_sequence", sequenceName = "BookUser_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Users user;

    private LocalDateTime borrowedDate;

    private LocalDateTime endDate;

    @PrePersist
    void create() {
        borrowedDate = LocalDateTime.now();
        endDate = borrowedDate.plusWeeks(2);
        book.setAvailable(Available.NO);
    }

    public BookUser() {
    }

    public BookUser(Book book, Users user) {
        this.book = book;
        this.user = user;
    }
}
