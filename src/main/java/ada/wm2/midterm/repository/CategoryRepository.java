package ada.wm2.midterm.repository;

import ada.wm2.midterm.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
