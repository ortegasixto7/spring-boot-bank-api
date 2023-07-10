package com.ortegasixto7.bankapi.external.auth;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAuthRepository extends CrudRepository<Auth, String> {
    Optional<Auth> findByUserName(String userName);
}
