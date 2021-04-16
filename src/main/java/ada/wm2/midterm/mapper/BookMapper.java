package ada.wm2.midterm.mapper;

import ada.wm2.midterm.entity.Book;
import ada.wm2.midterm.model.BookModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {


    BookModel toDto(Book book);
}
