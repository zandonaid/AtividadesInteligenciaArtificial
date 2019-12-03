package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.hillclimbingsearch;

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
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.problem.Problem;
import aima.core.search.local.HillClimbingSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.QuestaoaAtividade03Base;

/**
 * @author Felipe Silva Falcao
 *
 * Questão 4.1.1 Hill-climbing search
 */
public class QuestaoHillClimbingSearch extends QuestaoaAtividade03Base {

	@Override
	public Metrics problemaDoCaixeiroViajante() {
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);

		String agentLoc = SimplifiedRoadMapOfRomania.ARAD;
		String destination = SimplifiedRoadMapOfRomania.BUCHAREST;

		HillClimbingSearch<String, MoveToAction> search = 
				new HillClimbingSearch<>(MapFunctions.createSLDHeuristicFunction(destination, map));

		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		
		return search.getMetrics();
	}
	
	@Override
	public Metrics problemaDas8Rainhas() {
		int boardSize = 8;
		
		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize); 
		
		HillClimbingSearch<NQueensBoard, QueenAction> search = 
				new HillClimbingSearch<NQueensBoard, QueenAction>(NQueensFunctions::getNumberOfAttackingPairs);
		
		search.findActions(problem);
		
		return search.getMetrics();
	}

	@Override
	public Metrics problemaDoQuebraCabeca() {
		EightPuzzleBoard boardWithThreeMoveSolution = new EightPuzzleBoard(new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });
		
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(boardWithThreeMoveSolution);
		HillClimbingSearch<EightPuzzleBoard, Action> search = new HillClimbingSearch<EightPuzzleBoard, Action>(EightPuzzleFunctions::getManhattanDistance);
				
		SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
		
		agent.getActions();
		search.findActions(problem);
		
		return search.getMetrics();
	}

	@Override
	public String getNome() {
		return "Questão 4.1.1 Hill-climbing search";
	}

}
