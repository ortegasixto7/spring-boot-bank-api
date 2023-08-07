package com.ortegasixto7.bankapi.core.user;

import java.util.Optional;

public class User {
    public String id;
    public String firstName;
    public String lastName;
    public String userName;
    public Long createdAt;

    public static Optional<User> fromUserModel(Optional<UserModel> data) {
        if (data.isEmpty()) return Optional.empty();
        var result = new User();
        result.id = data.get().id;
        result.firstName = data.get().firstName;
        result.lastName = data.get().lastName;
        result.userName = data.get().userName;
        result.createdAt = data.get().createdAt;
        return Optional.of(result);
    }
}
