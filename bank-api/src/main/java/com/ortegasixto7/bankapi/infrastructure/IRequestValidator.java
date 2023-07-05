package com.ortegasixto7.bankapi.infrastructure;

public interface IRequestValidator<T> {
    void validate(T request) throws Exception;
}
