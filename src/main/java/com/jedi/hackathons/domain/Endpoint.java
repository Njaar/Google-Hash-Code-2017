package com.jedi.hackathons.domain;

import java.util.Map;

/**
 * Created by deenan.vythilingam on 2017/02/23.
 */
public class Endpoint {
    Map<Video, Long> videoRequests;
    Map<Server, Long> serverLatency;
    Long dataCenterLatency;

    public Map<Video, Long> getVideoRequests() {
        return videoRequests;
    }

    public void setVideoRequests(Map<Video, Long> videoRequests) {
        this.videoRequests = videoRequests;
    }

    public Map<Server, Long> getServerLatency() {
        return serverLatency;
    }

    public void setServerLatency(Map<Server, Long> serverLatency) {
        this.serverLatency = serverLatency;
    }

    public Long getDataCenterLatency() {
        return dataCenterLatency;
    }

    public void setDataCenterLatency(Long dataCenterLatency) {
        this.dataCenterLatency = dataCenterLatency;
    }
}
