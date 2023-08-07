package com.ortegasixto7.bankapi.external.auth;


import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class Auth {
    public String id = UUID.randomUUID().toString();
    public String userName;
    public String password;
    public Long createdAt = new Date().getTime();

    public static Optional<Auth> fromAuthModel(Optional<AuthModel> data) {
        if (data.isEmpty()) return Optional.empty();
        var result = new Auth();
        result.id = data.get().id;
        result.userName = data.get().userName;
        result.password = data.get().password;
        result.createdAt = data.get().createdAt;
        return Optional.of(result);
    }
}
