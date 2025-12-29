package com.thejoa.boot001.myjpa3;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@NoArgsConstructor  
@Getter  @Setter    
public class FollowId implements Serializable {
    private Long follower; // User의 ID와 매핑
    private Long following; // User의 ID와 매핑

    // Default Constructor
    // Constructor
    public FollowId(Long follower, Long following) {
        this.follower = follower;
        this.following = following;
    }

    // equals()와 hashCode() 재정의 (중요)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowId that = (FollowId) o;
        return follower.equals(that.follower) && following.equals(that.following);
    }

    @Override
    public int hashCode() {
        return Objects.hash(follower, following);
    }
}