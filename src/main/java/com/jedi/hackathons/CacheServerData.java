package com.jedi.hackathons;

/**
 * Created by deenan.vythilingam on 2017/02/23.
 */
public class CacheServerData {
    long serverId;
    long latency;

    public long getServerId() {
        return serverId;
    }

    public void setServerId(long serverId) {
        this.serverId = serverId;
    }

    public long getLatency() {
        return latency;
    }

    public void setLatency(long latency) {
        this.latency = latency;
    }
}
