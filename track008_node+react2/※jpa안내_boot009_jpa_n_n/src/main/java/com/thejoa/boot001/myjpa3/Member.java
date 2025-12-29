package com.thejoa.boot001.myjpa3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;

@Entity
@Getter 
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

//    @OneToMany(mappedBy = "member")
//    private List<Post> posts = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Comment> comments = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(
//        name = "Like",
//        joinColumns = @JoinColumn(name = "member_id"),
//        inverseJoinColumns = @JoinColumn(name = "post_id")
//    )
//    private List<Post> likedPosts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "Follow",
        joinColumns = @JoinColumn(name = "following_id"),
        inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private List<Member> followers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "Follow",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private List<Member> followings = new ArrayList<>();

    // Getters and Setters
}