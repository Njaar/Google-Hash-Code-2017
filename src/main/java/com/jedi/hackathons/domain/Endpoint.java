package com.jedi.hackathons.domain;

import java.util.Map;

/**
 * Created by deenan.vythilingam on 2017/02/23.
 */
public class Endpoint {
    Map<Video, Long> videoRequests;
    Map<Server, Long> serverLatency;
    Long dataCenterLatency;
}
