package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.geneticalgorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctions;
import aima.core.search.framework.Node;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.Individual;


/**
 * @author Eduardo Fillipe da Silva Reis
 * 
 * Classe de ultilitários para o algoritmo genético no problema do EightPuzzle
 */
public class EightPuzzleGenAlgoUtil {

	/**
	 * 
	 * Retorna o a função fitness do problema EightPuzzle a partir da Heurística da distância de Manhattan.
	 * 
	 * @return Função Fitness
	 */
	public static FitnessFunction<Integer> getFitnessFunctionByManhattanDistance() {
		EightPuzzleFitnessFunctionByManhattan ff =  new EightPuzzleFitnessFunctionByManhattan();
		return ff;
	}

	/**
	 * 
	 * Retorna o a função fitness do problema EightPuzzle a partir da Heurística da distância da quantidade de peças fora do lugar.
	 * 
	 * @return Função Fitness
	 */
	public static FitnessFunction<Integer> getFitnessFunctionByMissPlacedTiles() {
		return new EightPuzzleFitnessByMissPlacedTiles();
	}
	
	/**
	 * 
	 * Retorna o Goal Test do Problema Eight Puzzle.
	 * 
	 * @return Goal Test do Problema Eight Puzzle
	 */
	public static Predicate<Individual<Integer>> getEightPuzzleGoalTest() {
		return new EightPuzzleGenAlgGoalTest();
	}
	
	/**
	 * Retorna o Alfabeto do problema.
	 * 
	 * @return Lista contendo o alfabeto do problema do quebra cabeça.
	 */
	public static Collection<Integer> getAlphabet() {
		return Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8});
	}
	
	/**
	 * 
	 * @param individual Individuo a partir do qual será gerado a board.
	 * @return EightPuzzleBoard que representa o individuo dado.
	 */
	public static EightPuzzleBoard getBoardForIndividual(Individual<Integer> individual) {
		List<Integer> stateList = individual.getRepresentation();
		int[] stateInt = new int[stateList.size()];
		for (int i = 0; i < stateList.size(); i++) {
			stateInt[i] = stateList.get(i);
		}
		EightPuzzleBoard board = new EightPuzzleBoard(stateInt);
		return board;
	}
	/**
	 * Retorna um Individuo randomico do problema EightPuzzle representado como um array de inteiros.
	 * 
	 * @return Individuo Randômico
	 */
	
	public static Individual<Integer> getRandomIndividual() {
		List<Integer> representation = Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8});
		Collections.shuffle(representation);
		Individual<Integer> individual = new Individual<Integer>(representation);
		return individual;
	}
	
	/**
	 * Classe que representa uma função Fitness do problema Eight Puzzle, 
	 * utilizando a heurística da distância de Manhattan.
	 * 
	 * @author Eduardo Fillipe da Silva Reis
	 *
	 */
	private static class EightPuzzleFitnessFunctionByManhattan implements FitnessFunction<Integer>{
		
		@Override
		public double apply(Individual<Integer> individual) {
			double manhattanDistanceSum = 0;
			
			EightPuzzleBoard board = getBoardForIndividual(individual);
			manhattanDistanceSum = EightPuzzleFunctions.
					getManhattanDistance(new Node<EightPuzzleBoard, Action>(board));
			
			return manhattanDistanceSum * -1;
		}
	}
	
	/**
	 * Classe que representa uma função Fitness do problema Eight Puzzle, 
	 * utilizando a heurística da quantidade de peças em posições incorretas.
	 * 
	 * @author Eduardo Fillipe da Silva Reis
	 *
	 */
    private static class EightPuzzleFitnessByMissPlacedTiles implements FitnessFunction<Integer>{
		
		@Override
		public double apply(Individual<Integer> individual) {
			double missPlacedTiles = 0;
			
			EightPuzzleBoard board = getBoardForIndividual(individual);
			missPlacedTiles = EightPuzzleFunctions.getNumberOfMisplacedTiles(new Node<EightPuzzleBoard, Action>(board));
			
			return missPlacedTiles * -1;
		}
	}
    
    /**
     * Classe que representa o a função de verificação de goal state.
     * 
     * @author Eduardo Fillipe da Silva Reis
     *
     */
	private static class EightPuzzleGenAlgGoalTest implements Predicate<Individual<Integer>> {

		@Override
		public boolean test(Individual<Integer> state) {
			return EightPuzzleFunctions.GOAL_STATE.equals(getBoardForIndividual(state));
		}
	}
}

