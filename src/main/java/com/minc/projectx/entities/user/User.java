package com.minc.projectx.entities.user;

import javax.persistence.*;

@Entity
@Table(name="users")

public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "fk-role-id")
    private Role role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
