package com.jedi.hackathons;

import com.jedi.hackathons.domain.Endpoint;
import com.jedi.hackathons.domain.Server;
import com.jedi.hackathons.domain.Video;
import com.jedi.hackathons.input.CacheServerData;
import com.jedi.hackathons.input.EndpointData;
import com.jedi.hackathons.input.InputDto;
import com.jedi.hackathons.input.RequestDescription;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App 
{
//    private static final String INPUT_FILE_NAME = "A-small-attempt4.in";
//    private static final String OUTPUT_FILE_NAME = "result.txt";

    public static void main(String[] args){

        //Open file connections
        Scanner in = null;
        BufferedWriter out = null;
        try{
            in = new Scanner(new File(args[0]));
            out = new BufferedWriter(new FileWriter(args[1] , false));
        }catch(Exception e){
            e.printStackTrace();
        }

        InputDto inputDto = readFile(in);
        ArrayList<Endpoint> endpoints = generateEndpoints(inputDto);

        //Variables
        String output = "";
        //Output and close
        try{
            out.write(output);
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static ArrayList<Endpoint> generateEndpoints(InputDto inputDto) {
        ArrayList<Endpoint> list = new ArrayList<>();
        for (EndpointData endpointData :  inputDto.getEndpointDataList()) {
            list.add(createEndpoint(endpointData, inputDto.getRequestDescriptions()));
        }
        return list;
    }

    private static Endpoint createEndpoint(EndpointData endpointData, ArrayList<RequestDescription> requestDescriptions) {
        Endpoint endpoint = new Endpoint();
        endpoint.setDataCenterLatency(endpointData.getLatency());
        endpoint.setVideoRequests(createVideoRequestMap(endpointData, requestDescriptions));
//        endpoint.setServerLatency();
        return endpoint;
    }

    private static Map<Video, Long> createVideoRequestMap(EndpointData endpointData, ArrayList<RequestDescription> requestDescriptions) {
        Map<Video, Long> map = new HashMap<>();
//        map.put(createVideo(endpointData, requestDescriptions), )
        return map;
    }

    private static InputDto readFile(Scanner in) {
        InputDto inputDto = new InputDto();
        inputDto.setNumVideos(in.nextLong());
        inputDto.setNumEndpoints(in.nextLong());
        inputDto.setNumReqDescs(in.nextLong());
        inputDto.setNumCacheServers(in.nextLong());
        inputDto.setNumServerCapacity(in.nextLong());
        System.out.println(inputDto.getNumVideos() +" , "+ inputDto.getNumCacheServers() +" , "+ inputDto.getNumEndpoints() +" , "+ inputDto.getNumReqDescs() +" , "+ inputDto.getNumServerCapacity());
        ArrayList<Long> videoSizes = new ArrayList<>();
        for (int i = 0; i < inputDto.getNumVideos(); i++) {
            videoSizes.add(in.nextLong());
        }
        inputDto.setVideoSizes(videoSizes);

        inputDto.setEndpointDataList(new ArrayList<>());
        for (int i = 0; i < inputDto.getNumEndpoints(); i++) {
            EndpointData endpointData = new EndpointData();
            endpointData.setLatency(in.nextLong());
            endpointData.setNumCacheServers(in.nextLong());
            endpointData.setEndpointConnections(new ArrayList<>());
            for (int k = 0; k < endpointData.getNumCacheServers(); k++) {
                CacheServerData cacheServerData = new CacheServerData();
                cacheServerData.setServerId(in.nextLong());
                cacheServerData.setLatency(in.nextLong());
                endpointData.getEndpointConnections().add(cacheServerData);
            }
            inputDto.getEndpointDataList().add(endpointData);
        }
        inputDto.setRequestDescriptions(new ArrayList<>());
        for (int j = 0; j < inputDto.getNumReqDescs(); j++) {
            RequestDescription description = new RequestDescription();
            description.setVideoId(in.nextLong());
            description.setEndpointId(in.nextLong());
            description.setNumRequests(in.nextLong());
            inputDto.getRequestDescriptions().add(description);
        }
        return inputDto;
    }
}
