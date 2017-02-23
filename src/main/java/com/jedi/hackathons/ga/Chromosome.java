package com.jedi.hackathons.ga;

import java.util.List;

/**
 * Created by rishal on 2017/02/23.
 */
public class Chromosome {

    long serverId;
    List<Long> videos;

    long capacity;
    long remainingCapacity;

    public Chromosome(long serverId) {
        this.serverId = serverId;
        this.capacity = 0;
        this.remainingCapacity = capacity;
    }

}
