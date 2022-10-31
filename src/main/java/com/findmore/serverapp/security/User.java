package com.findmore.serverapp.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    public User() {}
    public User(String username, String password) { this.username = username; this.password = password; }

    @Column(name="username", length=45, unique=true)
    @Id private String username;
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column(name="password", length=72)
    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
