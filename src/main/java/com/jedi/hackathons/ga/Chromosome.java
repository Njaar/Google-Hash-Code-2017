package com.jedi.hackathons.ga;

import com.jedi.hackathons.domain.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishal on 2017/02/23.
 */
public class Chromosome {

    long serverId;
    List<Long> videos;

    long capacity;
    long remainingCapacity;

    public long getServerId() {
        return serverId;
    }

    public void setServerId(long serverId) {
        this.serverId = serverId;
    }

    public List<Long> getVideos() {
        return videos;
    }

    public void setVideos(List<Long> videos) {
        this.videos = videos;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(long remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    public Chromosome(long serverId, long capacity) {
        this.serverId = serverId;
        this.capacity = capacity;
        this.remainingCapacity = capacity;
        videos = new ArrayList<Long>();
    }

    public boolean validateAddVideo(long videoId, long videoSize) {
        if(remainingCapacity >= videoSize && !videos.contains(videoId)) {
            videos.add(videoId);
            remainingCapacity -= videoSize;
            return true;
        }
        return false;
    }

}
