package com.jedi.hackathons.input;

import java.util.ArrayList;

/**
 * Created by deenan.vythilingam on 2017/02/23.
 */
public class EndpointData {
    long latency;
    long numCacheServers;
    ArrayList<CacheServerData> endpointConnections;

    public long getLatency() {
        return latency;
    }

    public void setLatency(long latency) {
        this.latency = latency;
    }

    public long getNumCacheServers() {
        return numCacheServers;
    }

    public void setNumCacheServers(long numCacheServers) {
        this.numCacheServers = numCacheServers;
    }

    public ArrayList<CacheServerData> getEndpointConnections() {
        return endpointConnections;
    }

    public void setEndpointConnections(ArrayList<CacheServerData> endpointConnections) {
        this.endpointConnections = endpointConnections;
    }
}
