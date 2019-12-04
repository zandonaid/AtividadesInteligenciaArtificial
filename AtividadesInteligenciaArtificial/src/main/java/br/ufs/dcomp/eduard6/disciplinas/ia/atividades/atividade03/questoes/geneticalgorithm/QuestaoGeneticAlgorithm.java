package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.geneticalgorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import aima.core.environment.nqueens.NQueensGenAlgoUtil;
import aima.core.search.framework.Metrics;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.GeneticAlgorithm;
import aima.core.search.local.Individual;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.QuestaoaAtividade03Base;

/**
 * @author Eduardo Fillipe da Silva Reis
 *
 * Questão 4.1.3 - Genetic algorithms
 */
public class QuestaoGeneticAlgorithm extends QuestaoaAtividade03Base {

	@Override
	public Metrics problemaDoCaixeiroViajante() {
		return null;
	}

	@Override
	public Metrics problemaDas8Rainhas() {
		int boardSize = 8;

		FitnessFunction<Integer> fitnessFunction = NQueensGenAlgoUtil.getFitnessFunction();
		Predicate<Individual<Integer>> goalTest = NQueensGenAlgoUtil.getGoalTest();
		
		Set<Individual<Integer>> population = new HashSet<>();
		for (int i = 0; i < 50; i++)
			population.add(NQueensGenAlgoUtil.generateRandomIndividual(boardSize));

		GeneticAlgorithm<Integer> ga = new GeneticAlgorithm<>(boardSize,
				NQueensGenAlgoUtil.getFiniteAlphabetForBoardOfSize(boardSize), 0.15);

		ga.geneticAlgorithm(population, fitnessFunction, goalTest, 0L);
		
		return ga.getMetrics();
	}

	@SuppressWarnings("unused")
	@Override
	public Metrics problemaDoQuebraCabeca() {
		FitnessFunction<Integer> fitnessFunctionMahattan = EightPuzzleGenAlgoUtil.getFitnessFunctionByManhattanDistance();
		FitnessFunction<Integer> fitnessFunctionMissPlaced = EightPuzzleGenAlgoUtil.getFitnessFunctionByMissPlacedTiles();
		
		Predicate<Individual<Integer>> goalTest = EightPuzzleGenAlgoUtil.getEightPuzzleGoalTest();

		
		Set<Individual<Integer>> individualsPopulation = new HashSet<>();
		for (int i = 0; i < 50; i++) {
			individualsPopulation.add(EightPuzzleGenAlgoUtil.getRandomIndividual());
		}
		
		GeneticAlgorithm<Integer> ga = new GeneticAlgorithm<Integer>(9, EightPuzzleGenAlgoUtil.getAlphabet(), 0.15);
		
		Individual<Integer> i = ga.geneticAlgorithm(individualsPopulation, fitnessFunctionMissPlaced, goalTest, 5000L);
		
		//System.out.println(EightPuzzleGenAlgoUtil.getBoardForIndividual(i).toString());
		
		return ga.getMetrics();
	}

	@Override
	public String getNome() {
		return "Questão 4.1.3 - Genetic algorithms (Resolvido apenas para 8 Rainhas)";
	}
}
