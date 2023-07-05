package com.ortegasixto7.bankapi.infrastructure;

public interface IUseCaseCommand<T> {
    void execute(T request) throws Exception;
}
