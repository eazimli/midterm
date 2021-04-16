package ada.wm2.midterm.mapper;

import ada.wm2.midterm.entity.Comment;
import ada.wm2.midterm.model.CommentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentResponse toDto (Comment comment);
    List<CommentResponse> toDTOS(List<Comment> comments);
}
