package com.ortegasixto7.bankapi.core.user;

import java.util.Optional;

public interface IUserPersistence {
    void create(User data);
    void update(User data);
    Optional<User> getByIdOrNull(String id);
    User getByIdOrException(String id) throws Exception;
    Optional<User> getByUserNameOrNull(String userName);
}
