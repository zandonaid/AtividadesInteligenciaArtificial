package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.bestfirstsearch;

import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctions;
import aima.core.environment.map.ExtendableMap;
import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.impl.DynamicPercept;
import aima.core.environment.map.MapEnvironment;
import aima.core.environment.map.MapFunctions;
import aima.core.environment.map.MoveToAction;
import aima.core.environment.map.SimpleMapAgent;
import aima.core.environment.map.SimplifiedRoadMapOfRomania;
import aima.core.environment.nqueens.NQueensBoard;
import aima.core.environment.nqueens.NQueensFunctions;
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.QueueSearch;
import aima.core.search.informed.BestFirstSearch;
import aima.core.search.informed.EvaluationFunction;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.QuestaoaAtividade03Base;


public class QuestaoBestFirstSearch extends QuestaoaAtividade03Base{

	@Override
	public Metrics problemaDoCaixeiroViajante() {
		// TODO Auto-generated method stub
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);

		String agentLoc = SimplifiedRoadMapOfRomania.ARAD;
		String destination = SimplifiedRoadMapOfRomania.BUCHAREST;
		
		BestFirstSearch<String, MoveToAction> search;
		EvaluationFunction <String, MoveToAction> fn = new EvaluationFunction<String, MoveToAction>() {
			@Override
			public double applyAsDouble(Node<String, MoveToAction> arg0) {
				// TODO Auto-generated method stub
				return MapFunctions. getSLD(arg0.getState(), destination, map);
			}
		}; 
		
		QueueSearch<String, MoveToAction> fila = (new GraphSearch<>());
		search = new BestFirstSearch<String, MoveToAction>(fila, fn);
		
		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		return search.getMetrics();
	}

	@Override
	public Metrics problemaDas8Rainhas() {
		// TODO Auto-generated method stub
		Problem<NQueensBoard, QueenAction> problema = QuestaoaAtividade03Base.OITO_RAINHAS_COMPLETE_PROBLEM;
		BestFirstSearch<NQueensBoard, QueenAction> search;
		
		EvaluationFunction <NQueensBoard, QueenAction> fn = new EvaluationFunction<NQueensBoard, QueenAction>() {
			@Override
			public double applyAsDouble(Node<NQueensBoard, QueenAction> arg0) {
				// TODO Auto-generated method stub
				return NQueensFunctions.getNumberOfAttackingPairs(arg0);
			}
		};
		
		QueueSearch<NQueensBoard, QueenAction> fila = (new GraphSearch<>());
		search = new BestFirstSearch<NQueensBoard, QueenAction>(fila, fn);
		
		search.findActions(problema);
		return search.getMetrics();
	}

	@Override
	public Metrics problemaDoQuebraCabeca() {
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(QuestaoaAtividade03Base.QUEBRA_CABECA_TABULEIRO);
		BestFirstSearch<EightPuzzleBoard, Action> search;
		
		EvaluationFunction <EightPuzzleBoard, Action> fn = new EvaluationFunction<EightPuzzleBoard, Action>() {
			@Override
			public double applyAsDouble(Node<EightPuzzleBoard, Action> arg0) {
				// TODO Auto-generated method stub
				return EightPuzzleFunctions.getManhattanDistance(arg0);
			}
		};
		
		QueueSearch<EightPuzzleBoard, Action> fila = (new GraphSearch<>());
		search = new BestFirstSearch<EightPuzzleBoard, Action>(fila, fn);
		
		search.findState(problem);
		return search.getMetrics();
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Best-First Search";
	}

}
