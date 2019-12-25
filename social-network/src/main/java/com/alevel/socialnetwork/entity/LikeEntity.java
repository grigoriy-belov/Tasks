package com.alevel.socialnetwork.entity;

import javax.persistence.*;
import java.io.Serializable;

/*
    InheritanceType.SINGLE_TABLE can be used for better performance, but it increases
    the risk of data inconsistencies
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class LikeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    public LikeEntity() {
    }

    public LikeEntity(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

