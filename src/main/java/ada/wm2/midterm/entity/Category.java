package ada.wm2.midterm.entity;


import ada.wm2.midterm.model.Categories;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Category_sequence")
    @SequenceGenerator(name = "Category_sequence", sequenceName = "Category_sequence", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categories category;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;

    public Category(Categories categories) {
        this.category = categories;
    }
}
