package com.alevel.textboard.model;

import java.util.Objects;

public final class User {
    private final String email;
    private final String nickname;

    public User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
