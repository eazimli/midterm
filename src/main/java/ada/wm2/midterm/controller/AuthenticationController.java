package ada.wm2.midterm.controller;

import ada.wm2.midterm.model.RequestDto;
import ada.wm2.midterm.model.ResponseDto;
import ada.wm2.midterm.model.Status;
import ada.wm2.midterm.service.LoginService;
import ada.wm2.midterm.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthenticationController {
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final RegistrationService registrationService;
    private final LoginService loginService;

    public AuthenticationController(RegistrationService registrationService, LoginService loginService) {
        this.registrationService = registrationService;
        this.loginService = loginService;
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody @Validated RequestDto dto) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("message", "success");
        logger.info(dto.getEmail());
        logger.info(dto.getPassword());
        return ResponseEntity.created(null).headers(responseHeaders).body(registrationService.create(dto));
    }

    @PostMapping("/login")
    public Status login(@RequestBody RequestDto dto, HttpSession session) {
        logger.info(dto.getEmail());
        logger.info(dto.getPassword());
        return loginService.check(dto, session);
    }

}
