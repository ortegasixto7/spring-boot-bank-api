package com.ortegasixto7.bankapi.core.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<UserModel, String> {
    Optional<UserModel> findByUserName(String userName);
}
