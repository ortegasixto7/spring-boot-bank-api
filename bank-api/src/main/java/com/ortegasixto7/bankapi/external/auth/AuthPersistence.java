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
        this.database.save(data);
    }

    @Override
    public void update(Auth data) {
        this.database.save(data);
    }

    @Override
    public Optional<Auth> getByUserNameOrNull(String userName) {
        return this.database.findByUserName(userName);
    }
}
