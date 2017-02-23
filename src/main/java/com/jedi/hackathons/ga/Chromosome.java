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

    public Chromosome(long serverId, long capacity) {
        this.serverId = serverId;
        this.capacity = capacity;
        this.remainingCapacity = capacity;
    }

    public boolean validateAddVideo(long videoId, long videoSize) {
        if(remainingCapacity >= videoSize) {
            videos.add(videoId);
            remainingCapacity -= videoSize;
            return true;
        }
        return false;
    }

}
