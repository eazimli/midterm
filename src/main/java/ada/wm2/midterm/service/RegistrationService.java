package ada.wm2.midterm.service;

import ada.wm2.midterm.config.EncryptionAndDecryption;
import ada.wm2.midterm.controller.AuthenticationController;
import ada.wm2.midterm.entity.Users;
import ada.wm2.midterm.exception.UserExists;
import ada.wm2.midterm.mapper.RegistrationMapper;
import ada.wm2.midterm.model.RequestDto;
import ada.wm2.midterm.model.ResponseDto;
import ada.wm2.midterm.repository.RegistrationRepository;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;
    Logger logger = LoggerFactory.getLogger(RegistrationService.class);

    public RegistrationService(RegistrationRepository registrationRepository,
                               RegistrationMapper registrationMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationMapper = registrationMapper;
    }


    public ResponseDto create(RequestDto dto) {

        check(dto);
        return registrationMapper.toDto(registrationRepository.save(registrationMapper.toEntity(dto)));
    }

    @SneakyThrows
    private void check(RequestDto dto) {
        String email = dto.getEmail();
        dto.setPassword(EncryptionAndDecryption.encrypt(dto.getPassword(), "reg"));
        logger.info(dto.getPassword());
        if (registrationRepository.findByEmail(email).isPresent()) {
            logger.info("user with " + email + " existed");
            throw new UserExists("User already excised");
        }
    }

    public Users findByEmail(String email) {
        return registrationRepository.findByEmail(email).orElseThrow(RuntimeException::new);
    }
}