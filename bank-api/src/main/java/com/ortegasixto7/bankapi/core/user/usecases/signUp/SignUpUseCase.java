package com.ortegasixto7.bankapi.core.user.usecases.signUp;

import com.ortegasixto7.bankapi.core.user.IUserPersistence;
import com.ortegasixto7.bankapi.core.user.User;
import com.ortegasixto7.bankapi.external.auth.Auth;
import com.ortegasixto7.bankapi.external.auth.IAuthPersistence;
import com.ortegasixto7.bankapi.infrastructure.IUseCaseCommand;
import com.ortegasixto7.bankapi.infrastructure.exceptions.BadRequestException;
import com.ortegasixto7.bankapi.infrastructure.exceptions.ExceptionCode;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class SignUpUseCase implements IUseCaseCommand<SignUpRequest> {
    private final IUserPersistence userPersistence;
    private final IAuthPersistence authPersistence;

    public SignUpUseCase(IUserPersistence userPersistence, IAuthPersistence authPersistence) {
        this.userPersistence = userPersistence;
        this.authPersistence = authPersistence;
    }

    @Override
    public void execute(SignUpRequest request) throws Exception {
        new SignUpRequestValidator().validate(request);

        var authResult = this.authPersistence.getByUserNameOrNull(request.userName);
        if(!authResult.isEmpty()) throw new BadRequestException(ExceptionCode.UNAVAILABLE_USER_NAME);

        Auth auth = new Auth();
        auth.userName = request.userName;
        auth.password = BCrypt.hashpw(request.password, BCrypt.gensalt());

        var user = new User();
        user.id = auth.id;
        user.firstName = request.firstName;
        user.lastName = request.lastName;
        user.userName = request.userName;
        user.createdAt = auth.createdAt;
        this.userPersistence.create(user);
        this.authPersistence.create(auth);
    }
}
