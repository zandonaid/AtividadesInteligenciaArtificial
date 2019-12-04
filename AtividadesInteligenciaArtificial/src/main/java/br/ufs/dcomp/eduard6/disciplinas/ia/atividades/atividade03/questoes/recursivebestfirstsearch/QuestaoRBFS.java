package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.recursivebestfirstsearch;

import java.awt.List;
import java.util.Optional;
import java.util.function.ToDoubleFunction;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.impl.DynamicPercept;
import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctions;
import aima.core.environment.map.ExtendableMap;
import aima.core.environment.map.MapEnvironment;
import aima.core.environment.map.MapFunctions;
import aima.core.environment.map.MoveToAction;
import aima.core.environment.map.SimpleMapAgent;
import aima.core.environment.map.SimplifiedRoadMapOfRomania;
import aima.core.environment.nqueens.NQueensBoard;
import aima.core.environment.nqueens.NQueensFunctions;
import aima.core.environment.nqueens.NQueensGenAlgoUtil;
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.QueueSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.BestFirstSearch;
import aima.core.search.informed.EvaluationFunction;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.informed.RecursiveBestFirstSearch;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.GeneticAlgorithm;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.local.Individual;
import aima.core.search.local.Scheduler;
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
		
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);

		String agentLoc = CAIXEIRO_VIAJANTE_ORIGEM;
		String destination = CAIXEIRO_VIAJANTE_ORIGEM_DESTINO;
		
		RecursiveBestFirstSearch<String, MoveToAction> search = 
				new RecursiveBestFirstSearch<String, MoveToAction>(new EvaluationFunction<String, MoveToAction>() {
				    @Override
					public double applyAsDouble(Node<String, MoveToAction> arg0) {
						// TODO Auto-generated method stub
						return MapFunctions. getSLD(arg0.getState(), destination, map);
					}
                }, true);
		
		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		return search.getMetrics();
	}
	
	@Override
	public Metrics problemaDas8Rainhas() {
		Problem<NQueensBoard, QueenAction> problem = QuestaoaAtividade03Base.OITO_RAINHAS_INCREMENTAL_PROBLEM;
		
		RecursiveBestFirstSearch<NQueensBoard, QueenAction> search = 
				new RecursiveBestFirstSearch<NQueensBoard, QueenAction>(new EvaluationFunction<NQueensBoard, QueenAction>() {
				    @Override
				    public double applyAsDouble(Node<NQueensBoard, QueenAction> value) {
				        return NQueensFunctions.getNumberOfAttackingPairs(value);
				    }
                }, true);
		
		search.setHeuristicFunction(NQueensFunctions::getNumberOfAttackingPairs);
		
		search.findActions(problem);
		
		return search.getMetrics();
	}
	
	@Override
	public Metrics problemaDoQuebraCabeca() {
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(QuestaoaAtividade03Base.QUEBRA_CABECA_TABULEIRO);

		RecursiveBestFirstSearch<EightPuzzleBoard, Action> search = 
				new RecursiveBestFirstSearch<EightPuzzleBoard, Action>(new EvaluationFunction<EightPuzzleBoard, Action>() {
				    @Override
				    public double applyAsDouble(Node<EightPuzzleBoard, Action> value) {
				        return EightPuzzleFunctions.getManhattanDistance(value);
				    }
                }, true);
		
		search.setHeuristicFunction(EightPuzzleFunctions::getManhattanDistance);
		
		SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
		
		agent.getActions();
		agent.getInstrumentation();
		
		return search.getMetrics();
	}

	@Override
	public String getNome() {
		return "Questão 3.5.3 RBFS – Recursive best-first search";
	}

}
