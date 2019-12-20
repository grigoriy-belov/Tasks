package com.alevel.socialnetwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_likes")
public class UserLike {

    @OneToOne
    private User from;


    private List<User> to = new ArrayList<>();

    public UserLike() {
    }

    public UserLike(User from, User to) {
        this.from = from;
        this.to = to;
    }
}
