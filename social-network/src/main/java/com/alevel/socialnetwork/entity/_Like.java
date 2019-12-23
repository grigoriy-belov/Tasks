package com.alevel.socialnetwork.entity;

import javax.persistence.*;

/*
    InheritanceType.SINGLE_TABLE can be used for better performance, but it increases
    the risk of data inconsistencies
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class _Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    _Like() {
    }

    _Like(User author) {
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
