package com.ortegasixto7.bankapi.external.auth;

import java.util.Optional;

public interface IAuthPersistence {
    void create(Auth data);
    void update(Auth data);
    Optional<Auth> getByUserNameOrNull(String userName);
}
