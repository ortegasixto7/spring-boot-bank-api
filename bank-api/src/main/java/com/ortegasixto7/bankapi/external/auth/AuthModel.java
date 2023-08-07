package com.ortegasixto7.bankapi.external.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "auth")
public class AuthModel {
    @Id
    public String id = UUID.randomUUID().toString();
    @Column(name = "username")
    public String userName;
    @Column(name = "password")
    public String password;
    @Column(name = "roles")
    public String roles;
    @Column(name = "created_at")
    public Long createdAt = new Date().getTime();

    public static AuthModel fromAuth(Auth data) {
        var result = new AuthModel();
        result.id = data.id;
        result.userName = data.userName;
        result.password = data.password;
        result.createdAt = data.createdAt;

        String[] roles = new String[data.roles.size()];
        for (int i = 0; i < data.roles.size(); i++) {
            roles[i] = data.roles.get(i).toString();
        }

        result.roles = String.join(",", roles);

        return result;
    }
}
