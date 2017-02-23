package com.jedi.hackathons.ga;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishal on 2017/02/23.
 */
public class Individual {

    public List<Chromosome> chromosomes;
    public int score;

    public Individual() {
        chromosomes = new ArrayList<Chromosome>();
    }

}
