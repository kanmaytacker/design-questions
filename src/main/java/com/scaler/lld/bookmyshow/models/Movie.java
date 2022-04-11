package com.scaler.lld.bookmyshow.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "MOVIES")
public class Movie extends Auditable {

    private String name;
    private Integer durationMinutes;
    private Integer likes = 0;
    Lock lock = new ReentrantLock();
    
    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();

    public Integer upvote() {
        lock.lock();
        try {
            this.likes = this.likes + 1;
        } finally {
            lock.unlock();
        }
        return this.likes;
    }

}

// Customer 1 11 PM likes Avengers 0 + 1 = 1
// Customer 2 11 PM likes Avengers 0 + 1 = 1 
// 1 != 2 
// This is not check then act

// Customer 1 tries to upvote, the code reads the value of this.count = 0
// Customer 2 tries to upvote, the code reads the value of this.count = 0
// C1 thread does 0 + 1; Modify 
// C1 will write the value 1 to this.likes
// C2 thread does 0 + 1; Modify
// C2 will write the value 1 to this.likes

// Read-modify-write
