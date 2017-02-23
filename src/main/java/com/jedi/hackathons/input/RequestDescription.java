package com.jedi.hackathons.input;

/**
 * Created by deenan.vythilingam on 2017/02/23.
 */
public class RequestDescription {
    long videoId;
    long endpointId;
    long numRequests;

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public long getEndpointId() {
        return endpointId;
    }

    public void setEndpointId(long endpointId) {
        this.endpointId = endpointId;
    }

    public long getNumRequests() {
        return numRequests;
    }

    public void setNumRequests(long numRequests) {
        this.numRequests = numRequests;
    }
}
