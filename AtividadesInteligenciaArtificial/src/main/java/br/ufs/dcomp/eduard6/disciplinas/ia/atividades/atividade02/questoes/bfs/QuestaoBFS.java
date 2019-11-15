package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.questoes.bfs;

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
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.common.questao.QuestaoExecutavel;

public class QuestaoBFS extends QuestaoExecutavel {

	@Override
	public void execute() {
		problemaDoCaixeiroViajante();
		System.out.println();
		problemaDas8Rainhas();
		System.out.println();
		problemaDoQuebraCabeca();
	}

	@Override
	public String getNome() {
		return "Questão 1 - Breadth-first search";
	}
	
	
	private void problemaDoCaixeiroViajante() {
		System.out.println("Problema do caxeiro viajante: ");
		
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);

		String agentLoc = SimplifiedRoadMapOfRomania.ARAD;
		String destination = SimplifiedRoadMapOfRomania.BUCHAREST;

		SearchForActions<String, MoveToAction> search;
		search = new BreadthFirstSearch<String, MoveToAction>();

		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		System.out.println("Custo: " + search.getMetrics().toString());
	}
	
	private void problemaDas8Rainhas() {
		System.out.println("Problema das 8 Rainhas: ");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(8);
		SearchForActions<NQueensBoard, QueenAction> search = new BreadthFirstSearch<>(new GraphSearch<>());
		search.findActions(problem);
		System.out.println("Custo: " + search.getMetrics().toString());
	}
	
	private void problemaDoQuebraCabeca() {
		System.out.println("Problema do Quebra Cabeça: ");
		
		EightPuzzleBoard boardWithThreeMoveSolution =
				new EightPuzzleBoard(new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });
		
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(boardWithThreeMoveSolution);
		SearchForActions<EightPuzzleBoard, Action> search = new BreadthFirstSearch<EightPuzzleBoard, Action>();
		search.findActions(problem);
		System.out.println("Custo: " + search.getMetrics().toString());
	}
}
