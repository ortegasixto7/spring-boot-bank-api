package com.ortegasixto7.bankapi.useCases.user.signUp;

import com.ortegasixto7.bankapi.infrastructure.IRequestValidator;
import com.ortegasixto7.bankapi.infrastructure.exceptions.BadRequestException;
import com.ortegasixto7.bankapi.infrastructure.exceptions.Exception;

public class SignUpRequestValidator implements IRequestValidator<SignUpRequest> {
    @Override
    public void validate(SignUpRequest request) throws BadRequestException {
        if (request.firstName == null || request.firstName.isEmpty()) throw new BadRequestException(Exception.FIRST_NAME_IS_REQUIRED);
        if (request.lastName == null || request.lastName.isEmpty()) throw new BadRequestException(Exception.LAST_NAME_IS_REQUIRED);
        if (request.userName == null || request.userName.isEmpty()) throw new BadRequestException(Exception.USER_NAME_IS_REQUIRED);
        if (request.password == null || request.password.isEmpty()) throw new BadRequestException(Exception.PASSWORD_IS_REQUIRED);
    }
}
