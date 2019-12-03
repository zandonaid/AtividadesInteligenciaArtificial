package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.recursivebestfirstsearch;

import java.util.function.ToDoubleFunction;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.impl.DynamicPercept;
import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.map.ExtendableMap;
import aima.core.environment.map.MapEnvironment;
import aima.core.environment.map.MoveToAction;
import aima.core.environment.map.SimpleMapAgent;
import aima.core.environment.map.SimplifiedRoadMapOfRomania;
import aima.core.environment.nqueens.NQueensBoard;
import aima.core.environment.nqueens.NQueensFunctions;
import aima.core.environment.nqueens.NQueensGenAlgoUtil;
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.BestFirstSearch;
import aima.core.search.informed.EvaluationFunction;
import aima.core.search.informed.RecursiveBestFirstSearch;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.GeneticAlgorithm;
import aima.core.search.local.Individual;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.QuestaoaAtividade03Base;

/**
 * @author Felipe Silva Falcao
 *
 * Questão 3.5.3 RBFS – Recursive best-first search
 */
public class QuestaoRBFS extends QuestaoaAtividade03Base {

	@Override
	public Metrics problemaDoCaixeiroViajante() {
		return null;
	}
	
	@Override
	public Metrics problemaDas8Rainhas() {
		int boardSize = 8;
		
		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize);
		
		
		//return search.getMetrics();
		return null;
	}
	
	@Override
	public Metrics problemaDoQuebraCabeca() {
		EightPuzzleBoard boardWithThreeMoveSolution =
				new EightPuzzleBoard(new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 }); // Criando tabela
		
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(boardWithThreeMoveSolution);
		
		//ToDoubleFunction<Node<EightPuzzleBoard, Action>> h = setHeuristicFunction;
		
		EvaluationFunction<EightPuzzleBoard, Action> evalfn = null;
		
		SearchForActions<EightPuzzleBoard, Action> search = new RecursiveBestFirstSearch<EightPuzzleBoard, Action>(evalfn, true);
		
		search.findActions(problem);
		
		//return search.getMetrics();
		return null;
	}

	@Override
	public String getNome() {
		return "Questão 3.5.3 RBFS – Recursive best-first search";
	}

}
