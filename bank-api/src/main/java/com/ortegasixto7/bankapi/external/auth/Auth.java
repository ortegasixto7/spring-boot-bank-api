package com.ortegasixto7.bankapi.external.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "auth")
public class Auth {
    @Id
    public String id = UUID.randomUUID().toString();
    @Column(name = "username")
    public String userName;
    @Column(name = "password")
    public String password;
    @Column(name = "created_at")
    public Long createdAt = new Date().getTime();
}
