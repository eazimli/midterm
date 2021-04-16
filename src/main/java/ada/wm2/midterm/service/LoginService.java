package ada.wm2.midterm.service;

import ada.wm2.midterm.config.EncryptionAndDecryption;
import ada.wm2.midterm.controller.AuthenticationController;
import ada.wm2.midterm.entity.Users;
import ada.wm2.midterm.mapper.RegistrationMapper;
import ada.wm2.midterm.model.RequestDto;
import ada.wm2.midterm.model.Status;
import ada.wm2.midterm.repository.RegistrationRepository;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class LoginService {
    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;
    Logger logger = LoggerFactory.getLogger(LoginService.class);

    public LoginService(RegistrationRepository registrationRepository, RegistrationMapper registrationMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationMapper = registrationMapper;
    }


    @SneakyThrows
    public Status check(@SessionAttribute("user") RequestDto dto, HttpSession session) {
        String email = dto.getEmail();
        dto.setPassword(EncryptionAndDecryption.encrypt(dto.getPassword(), "reg"));
        String pass = dto.getPassword();
        logger.info(pass);
        Optional<Users> user = registrationRepository.findByEmailAndPassword(email, pass);
        if (user.isPresent()) {
            session.setAttribute("email", email);
            return Status.SUCCESS;
        } else {
            logger.info("login failed");
            return Status.FAILURE;
        }
    }
}
