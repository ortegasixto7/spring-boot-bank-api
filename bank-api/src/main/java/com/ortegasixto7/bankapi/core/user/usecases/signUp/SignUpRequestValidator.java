package com.ortegasixto7.bankapi.core.user.usecases.signUp;

import com.ortegasixto7.bankapi.infrastructure.IRequestValidator;

public class SignUpRequestValidator implements IRequestValidator<SignUpRequest> {
    @Override
    public void validate(SignUpRequest request) throws Exception {
        if (request.firstName == null || request.firstName.isEmpty()) throw new Exception("FIRST_NAME_IS_REQUIRED");
        if (request.lastName == null || request.lastName.isEmpty()) throw new Exception("LAST_NAME_IS_REQUIRED");
        if (request.userName == null || request.userName.isEmpty()) throw new Exception("USER_NAME_IS_REQUIRED");
        if (request.password == null || request.password.isEmpty()) throw new Exception("PASSWORD_IS_REQUIRED");
    }
}
