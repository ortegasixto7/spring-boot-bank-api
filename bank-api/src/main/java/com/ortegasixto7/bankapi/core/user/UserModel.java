package com.ortegasixto7.bankapi.core.user;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class UserModel {
    @Id
    public String id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
    @Column(name = "username")
    public String userName;
    @Column(name = "created_at")
    public Long createdAt;

    public static UserModel fromUser(User data) {
        var result = new UserModel();
        result.id = data.id;
        result.firstName = data.firstName;
        result.lastName = data.lastName;
        result.userName = data.userName;
        result.createdAt = data.createdAt;
        return result;
    }
}
