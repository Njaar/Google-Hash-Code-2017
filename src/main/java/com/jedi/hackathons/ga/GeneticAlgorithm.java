package com.jedi.hackathons.ga;

import com.jedi.hackathons.domain.Endpoint;
import com.jedi.hackathons.domain.Server;
import com.jedi.hackathons.domain.Video;
import com.jedi.hackathons.input.InputDto;

import java.util.*;

/**
 * Created by rishal on 2017/02/23.
 */
public class GeneticAlgorithm {

    Population currentGeneration;
    Population nextGeneration;
    InputDto inputDto;
    List<Endpoint> endpoints;
    List<Server> servers;

    public GeneticAlgorithm(InputDto inputDto, List<Endpoint> endpoints, List<Server> servers) {
        this.inputDto = inputDto;
        this.endpoints = endpoints;
        this.servers = servers;
        currentGeneration = generateInitalPopulation(1000);
    }

    public Population generateInitalPopulation(long populationSize) {
        Population population = new Population();
        for(int i = 0; i < populationSize; i++) {
            Individual individual = new Individual();
            for(Server server : servers) {
                Chromosome chromosome = new Chromosome(server.getId(), server.getCapacity());
                for(Endpoint endpoint: endpoints) {
                    if(endpoint.getServerLatency().containsKey(server)) {
                        for(Video video : getShuffledSet(endpoint.getVideoRequests().keySet())) {
                            chromosome.validateAddVideo(video.getId(), video.getSize());
                        }
                    }
                }
                individual.chromosomes.add(chromosome);
            }
            population.individuals.add(individual);
        }
        return population;
    }

    public Individual getBestIndividual() {
        return currentGeneration.individuals.get(42);
    }

    public List<Video> getShuffledSet(Set<Video> videos) {
        Set<Video> videoSet = new HashSet<Video>();
        for(Video video : videos) {
            videoSet.add(video);
        }
        List<Video> videoList = new ArrayList<Video>(videoSet);
        Collections.shuffle(videoList);
        return videoList;
    }



}
