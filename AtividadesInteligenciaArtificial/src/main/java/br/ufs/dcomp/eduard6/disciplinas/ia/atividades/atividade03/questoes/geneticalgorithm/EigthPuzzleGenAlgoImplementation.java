package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.geneticalgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import aima.core.search.local.GeneticAlgorithm;
import aima.core.search.local.Individual;

public class EigthPuzzleGenAlgoImplementation extends GeneticAlgorithm<Integer> {

    public EigthPuzzleGenAlgoImplementation(int individualLength,
            Collection<Integer> finiteAlphabet, double mutationProbability) {
        super(individualLength, finiteAlphabet, mutationProbability);
    }

    public EigthPuzzleGenAlgoImplementation(int individualLength,
            Collection<Integer> finiteAlphabet, double mutationProbability,
            Random random) {
        super(individualLength, finiteAlphabet, mutationProbability, random);
    }

    @Override
    protected Individual<Integer> reproduce(Individual<Integer> x,
            Individual<Integer> y) {
        int c = randomOffset(individualLength);
        
        List<Integer> childRepresentation = new ArrayList<>(x.getRepresentation());
        
        List<Integer> alphabet = new ArrayList<Integer>(this.finiteAlphabet);
        Random rnd = new Random();
        
        for (int i = 0; i < c; i++) {
        	int index = rnd.nextInt(alphabet.size());
        	int element = alphabet.get(index);
        	int iX = x.getRepresentation().indexOf(element);
        	int iY = y.getRepresentation().get(iX);
        	
        	childRepresentation.set(iY, element);
        	alphabet.remove(index);
        }

        return new Individual<>(childRepresentation);
    }

    @Override
    protected Individual<Integer> mutate(Individual<Integer> child) {
        return super.mutate(child);
    }
}
