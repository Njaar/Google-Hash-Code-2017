package com.jedi.hackathons.ga;

import com.jedi.hackathons.input.InputDto;

import java.util.List;

/**
 * Created by rishal on 2017/02/23.
 */
public class GeneticAlgorithm {

    Population currentGeneration;
    Population nextGeneration;
    InputDto inputDto;

    public GeneticAlgorithm(InputDto inputDto) {
        this.inputDto = inputDto;
    }

    public List<Population> generateInitalPopulation(long populationSize) {
        for(int i = 0; i < populationSize; i++) {
            Individual individual = new Individual();
            Chromosome dataCentre = new Chromosome(inputDto.getNumVideos());
            for(long r = 0; r < inputDto.getNumVideos(); i++) {
                dataCentre.videos.add(r);
            }
            individual.chromosomes.add(dataCentre);
            for(long r = 0; r < inputDto.getNumCacheServers(); r++) {
                Chromosome chromosome = new Chromosome(r);
                individual.chromosomes.add(chromosome);

            }
        }
        return null;
    }




}
