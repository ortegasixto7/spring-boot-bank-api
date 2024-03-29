package com.ortegasixto7.bankapi.controllers;

import com.ortegasixto7.bankapi.core.user.IUserPersistence;
import com.ortegasixto7.bankapi.useCases.user.signUp.SignUpRequest;
import com.ortegasixto7.bankapi.useCases.user.signUp.SignUpUseCase;
import com.ortegasixto7.bankapi.external.auth.IAuthPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserPersistence userPersistence;
    @Autowired
    IAuthPersistence authPersistence;

    @PostMapping("/sign-up/v1")
    public ResponseEntity signUp(@RequestBody SignUpRequest request) {
        new SignUpUseCase(this.userPersistence, this.authPersistence).execute(request);
        return new ResponseEntity(HttpStatus.OK);
    }
}
