package com.ortegasixto7.bankapi.core.user.usecases.signUp;

import com.ortegasixto7.bankapi.core.user.IUserPersistence;
import com.ortegasixto7.bankapi.core.user.User;
import com.ortegasixto7.bankapi.infrastructure.IUseCaseCommand;
import org.springframework.stereotype.Service;

@Service
public class SignUpUseCase implements IUseCaseCommand<SignUpRequest> {
    private final IUserPersistence userPersistence;

    public SignUpUseCase(IUserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    @Override
    public void execute(SignUpRequest request) throws Exception {
        new SignUpRequestValidator().validate(request);
        var user = new User();
        user.firstName = request.firstName;
        user.lastName = request.lastName;
        user.userName = request.userName;
        this.userPersistence.create(user);
    }
}
