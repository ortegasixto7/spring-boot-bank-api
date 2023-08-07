package com.ortegasixto7.bankapi.external.auth;


import java.util.*;

public class Auth {
    public String id = UUID.randomUUID().toString();
    public String userName;
    public String password;
    public ArrayList<AuthRole> roles = new ArrayList<>(Arrays.asList(AuthRole.USER));
    public Long createdAt = new Date().getTime();

    public static Optional<Auth> fromAuthModel(Optional<AuthModel> data) {
        if (data.isEmpty()) return Optional.empty();
        var result = new Auth();
        result.id = data.get().id;
        result.userName = data.get().userName;
        result.password = data.get().password;
        result.createdAt = data.get().createdAt;
        result.roles.clear();
        for (String role : data.get().roles.split(",")) {
            AuthRole roleValue = AuthRole.valueOf(role);
            result.roles.add(roleValue);
        }

        return Optional.of(result);
    }
}
