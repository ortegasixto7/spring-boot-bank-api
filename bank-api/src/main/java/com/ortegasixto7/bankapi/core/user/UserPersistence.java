package com.ortegasixto7.bankapi.core.user;

import com.ortegasixto7.bankapi.infrastructure.exceptions.Exception;
import com.ortegasixto7.bankapi.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserPersistence implements IUserPersistence {
    @Autowired
    IUserRepository database;
    @Override
    public void create(User data) {
        Runnable runnable = () -> this.database.save(UserModel.fromUser(data));
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void update(User data) {
        this.database.save(UserModel.fromUser(data));
    }

    @Override
    public Optional<User> getByIdOrNull(String id) {
        return User.fromUserModel(this.database.findById(id));
    }

    @Override
    public User getByIdOrException(String id) throws NotFoundException {
        var user = this.getByIdOrNull(id);
        if(user.isEmpty()) throw new NotFoundException(Exception.USER_NOT_FOUND);
        return user.get();
    }

    @Override
    public Optional<User> getByUserNameOrNull(String userName) {
        return User.fromUserModel(this.database.findByUserName(userName));
    }
}
