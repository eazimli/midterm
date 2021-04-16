package ada.wm2.midterm.controller;

import ada.wm2.midterm.entity.BookUser;
import ada.wm2.midterm.model.BookUserDto;
import ada.wm2.midterm.model.Status;
import ada.wm2.midterm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/pick")
    public Status pick(@Validated @RequestBody BookUserDto dto, HttpSession session) {
        logger.info(dto.toString());
        return userService.create(dto, session);
    }

    @PostMapping("/drop")
    public Status drop(@Validated @RequestBody BookUserDto dto, HttpSession session) {
        logger.info(dto.toString());
        return userService.drop(dto, session);
    }

    @PostMapping("/all")
    public ResponseEntity<List<BookUser>> getAll(HttpSession session) {
        return new ResponseEntity<>(userService.all(session), HttpStatus.OK);
    }
}
