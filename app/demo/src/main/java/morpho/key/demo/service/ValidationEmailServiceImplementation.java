package morpho.key.demo.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class ValidationEmailServiceImplementation implements ValidationEmailService {

    @Override
    public boolean validateEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
    @Override
    public boolean validdateDomainEmail(String email) {
        return false;
    }
}
