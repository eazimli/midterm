package ada.wm2.midterm.mapper;

import ada.wm2.midterm.entity.Users;
import ada.wm2.midterm.model.RequestDto;
import ada.wm2.midterm.model.ResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    Users toEntity(RequestDto dto);

    ResponseDto toDto(Users users);
}
