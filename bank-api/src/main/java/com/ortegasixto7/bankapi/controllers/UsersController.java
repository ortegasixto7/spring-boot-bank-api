package com.ortegasixto7.bankapi.controllers;

import com.ortegasixto7.bankapi.core.user.IUserPersistence;
import com.ortegasixto7.bankapi.core.user.usecases.signUp.SignUpRequest;
import com.ortegasixto7.bankapi.core.user.usecases.signUp.SignUpUseCase;
import com.ortegasixto7.bankapi.external.auth.IAuthPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    IUserPersistence userPersistence;
    @Autowired
    IAuthPersistence authPersistence;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpRequest request) throws Exception {
        new SignUpUseCase(this.userPersistence, this.authPersistence).execute(request);
        return new ResponseEntity(HttpStatus.OK);
    }
}
