package com.ortegasixto7.bankapi.external.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthPersistence implements IAuthPersistence {
    @Autowired
    IAuthRepository database;
    @Override
    public void create(Auth data) {
        Runnable runnable = () -> this.database.save(AuthModel.fromAuth(data));
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void update(Auth data) {
        this.database.save(AuthModel.fromAuth(data));
    }

    @Override
    public Optional<Auth> getByUserNameOrNull(String userName) {
        return Auth.fromAuthModel(this.database.findByUserName(userName));
    }
}
