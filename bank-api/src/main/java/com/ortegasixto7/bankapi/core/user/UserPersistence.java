package com.ortegasixto7.bankapi.core.user;

import com.ortegasixto7.bankapi.infrastructure.exceptions.ExceptionCode;
import com.ortegasixto7.bankapi.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserPersistence implements IUserPersistence{
    @Autowired
    IUserRepository database;
    @Override
    public void create(User user) {
        this.database.save(user);
    }

    @Override
    public void update(User user) {
        this.database.save(user);
    }

    @Override
    public Optional<User> getByIdOrNull(String id) {
        return this.database.findById(id);
    }

    @Override
    public User getByIdOrException(String id) throws NotFoundException {
        var user = this.getByIdOrNull(id);
        if(user.isEmpty()) throw new NotFoundException(ExceptionCode.USER_NOT_FOUND);
        return user.get();
    }

    @Override
    public Optional<User> getByUserNameOrNull(String userName) {
        return this.database.findByUserName(userName);
    }
}
