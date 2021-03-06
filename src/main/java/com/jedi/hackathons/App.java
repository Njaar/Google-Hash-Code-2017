package com.jedi.hackathons;

import com.jedi.hackathons.domain.Endpoint;
import com.jedi.hackathons.domain.Server;
import com.jedi.hackathons.domain.Video;
import com.jedi.hackathons.ga.Chromosome;
import com.jedi.hackathons.ga.Individual;
import com.jedi.hackathons.ga.GeneticAlgorithm;
import com.jedi.hackathons.ga.Individual;
import com.jedi.hackathons.input.CacheServerData;
import com.jedi.hackathons.input.EndpointData;
import com.jedi.hackathons.input.InputDto;
import com.jedi.hackathons.input.RequestDescription;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App 
{
    private static final String INPUT_FILE_NAME = "trending_today.in";
    private static final String OUTPUT_FILE_NAME = "tredning.txt";

    public static void main(String[] args){

        //Open file connections
        Scanner in = null;
        BufferedWriter out = null;
        try{
            in = new Scanner(new File(INPUT_FILE_NAME));
            out = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME , false));
        }catch(Exception e){
            e.printStackTrace();
        }

        InputDto inputDto = readFile(in);
        ArrayList<Endpoint> endpoints = generateEndpoints(inputDto);
        ArrayList<Server> servers = getServers(inputDto);

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(inputDto, endpoints, servers);
        Individual individual = geneticAlgorithm.getBestIndividual();

        //Output and close
        try{
            printIndividual(individual, out);
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void printIndividual(Individual individual, BufferedWriter out) throws IOException {
        out.write(String.valueOf(individual.chromosomes.size()));
        for (int i = 0; i < individual.chromosomes.size(); i++) {
            out.newLine();
            Chromosome c = individual.chromosomes.get(i);
            out.write(String.valueOf(c.getServerId()));
            for (int j = 0; j < c.getVideos().size(); j++)
            {
                out.write(" ");
                out.write(String.valueOf(c.getVideos().get(j)));
            }
        }
    }

    private static ArrayList<Server> getServers(InputDto inputDto) {
        Map<Long, Server> servers = new HashMap<>();
        for (EndpointData endpointData :  inputDto.getEndpointDataList()) {
            for (Server server : createServers(endpointData, inputDto.getNumServerCapacity()).keySet()) {
                servers.put(server.getId(), server);
            }
        }
        return new ArrayList<>(servers.values());
    }

    private static ArrayList<Endpoint> generateEndpoints(InputDto inputDto) {
        ArrayList<Endpoint> list = new ArrayList<>();
        for (EndpointData endpointData :  inputDto.getEndpointDataList()) {
            list.add(createEndpoint(endpointData, inputDto.getRequestDescriptions(), inputDto.getVideoSizes(), inputDto.getNumServerCapacity()));
        }
        return list;
    }

    private static Endpoint createEndpoint(EndpointData endpointData, Map<Long, RequestDescription> requestDescriptions, ArrayList<Long> videoSizes, long numServerCapacity) {
        Endpoint endpoint = new Endpoint();
        endpoint.setDataCenterLatency(endpointData.getLatency());
        endpoint.setVideoRequests(createVideoRequestMap(endpointData, videoSizes, requestDescriptions));
        endpoint.setServerLatency(createServers(endpointData, numServerCapacity));
        return endpoint;
    }

    private static Map<Server, Long> createServers(EndpointData endpointData, long numServerCapacity) {
        Map<Server, Long> map = new HashMap<>();
        for (int i = 0; i < endpointData.getEndpointConnections().size(); i++) {
            CacheServerData cacheServerData =  endpointData.getEndpointConnections().get(i);
            map.put(createServer(cacheServerData.getServerId(), numServerCapacity), cacheServerData.getLatency());
        }
        return map;
    }

    private static Server createServer(Long id, Long capacity) {
        Server server = new Server();
        server.setId(id);
        server.setCapacity(capacity);
        return server;
    }

    private static Map<Video, Long> createVideoRequestMap(EndpointData endpointData, ArrayList<Long> videoSizes, Map<Long, RequestDescription> requestDescriptions) {
        Map<Video, Long> videomap = new HashMap<>();
        for (int i = 0; i < endpointData.getEndpointConnections().size(); i++) {
            videomap.put(createVideo(i, videoSizes.get(i)), requestDescriptions.get((long)i).getNumRequests());
        }
        return videomap;
    }

    private static Video createVideo(long videoId, Long videoSize) {
        Video video = new Video();
        video.setId(videoId);
        video.setSize(videoSize);
        return video;
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
        inputDto.setRequestDescriptions(new HashMap<>());
        for (int j = 0; j < inputDto.getNumReqDescs(); j++) {
            RequestDescription description = new RequestDescription();
            description.setVideoId(in.nextLong());
            description.setEndpointId(in.nextLong());
            description.setNumRequests(in.nextLong());
            inputDto.getRequestDescriptions().put(description.getVideoId(), description);
        }
        return inputDto;
    }
}
