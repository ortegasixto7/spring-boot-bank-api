package com.ortegasixto7.bankapi.core.user.usecases.signUp;

import com.ortegasixto7.bankapi.infrastructure.IRequestValidator;
import com.ortegasixto7.bankapi.infrastructure.exceptions.BadRequestException;
import com.ortegasixto7.bankapi.infrastructure.exceptions.ExceptionCode;

public class SignUpRequestValidator implements IRequestValidator<SignUpRequest> {
    @Override
    public void validate(SignUpRequest request) throws BadRequestException {
        if (request.firstName == null || request.firstName.isEmpty()) throw new BadRequestException(ExceptionCode.FIRST_NAME_IS_REQUIRED);
        if (request.lastName == null || request.lastName.isEmpty()) throw new BadRequestException(ExceptionCode.LAST_NAME_IS_REQUIRED);
        if (request.userName == null || request.userName.isEmpty()) throw new BadRequestException(ExceptionCode.USER_NAME_IS_REQUIRED);
        if (request.password == null || request.password.isEmpty()) throw new BadRequestException(ExceptionCode.PASSWORD_IS_REQUIRED);
    }
}
