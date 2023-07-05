package com.ortegasixto7.bankapi.infrastructure;

public interface IUseCaseQuery<T, R> {
    R execute(T request);
}
