package ada.wm2.midterm.controller;

import ada.wm2.midterm.model.CommentDto;
import ada.wm2.midterm.model.ReplyDto;
import ada.wm2.midterm.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comment")
    ResponseEntity<String> comment(@RequestBody @Validated CommentDto dto){
        return commentService.comment(dto);
    }

    @PostMapping("/reply")
    ResponseEntity<String> reply(@RequestBody @Validated ReplyDto dto){
        return commentService.reply(dto);
    }


}
