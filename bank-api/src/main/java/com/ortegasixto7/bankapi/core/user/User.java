package com.ortegasixto7.bankapi.core.user;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    public String id = UUID.randomUUID().toString();
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
    @Column(name = "username")
    public String userName;
    @Column(name = "created_at")
    public Long createdAt = new Date().getTime();
}
