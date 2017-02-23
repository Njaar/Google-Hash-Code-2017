package com.jedi.hackathons.input;

import java.util.ArrayList;

/**
 * Created by deenan.vythilingam on 2017/02/23.
 */
public class InputDto {
    long numVideos;
    long numEndpoints;
    long numReqDescs;
    long numCacheServers;
    long numServerCapacity;
    ArrayList<Long> videoSizes;
    ArrayList<EndpointData> endpointDataList;
    ArrayList<RequestDescription> requestDescriptions;

    public long getNumVideos() {
        return numVideos;
    }

    public void setNumVideos(long numVideos) {
        this.numVideos = numVideos;
    }

    public long getNumEndpoints() {
        return numEndpoints;
    }

    public void setNumEndpoints(long numEndpoints) {
        this.numEndpoints = numEndpoints;
    }

    public long getNumReqDescs() {
        return numReqDescs;
    }

    public void setNumReqDescs(long numReqDescs) {
        this.numReqDescs = numReqDescs;
    }

    public long getNumCacheServers() {
        return numCacheServers;
    }

    public void setNumCacheServers(long numCacheServers) {
        this.numCacheServers = numCacheServers;
    }

    public long getNumServerCapacity() {
        return numServerCapacity;
    }

    public void setNumServerCapacity(long numServerCapacity) {
        this.numServerCapacity = numServerCapacity;
    }

    public ArrayList<Long> getVideoSizes() {
        return videoSizes;
    }

    public void setVideoSizes(ArrayList<Long> videoSizes) {
        this.videoSizes = videoSizes;
    }

    public ArrayList<EndpointData> getEndpointDataList() {
        return endpointDataList;
    }

    public void setEndpointDataList(ArrayList<EndpointData> endpointDataList) {
        this.endpointDataList = endpointDataList;
    }

    public ArrayList<RequestDescription> getRequestDescriptions() {
        return requestDescriptions;
    }

    public void setRequestDescriptions(ArrayList<RequestDescription> requestDescriptions) {
        this.requestDescriptions = requestDescriptions;
    }
}
