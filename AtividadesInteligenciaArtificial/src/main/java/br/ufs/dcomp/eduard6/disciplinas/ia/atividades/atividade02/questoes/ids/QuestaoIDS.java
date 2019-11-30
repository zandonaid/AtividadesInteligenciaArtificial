package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.questoes.ids;

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
import aima.core.search.framework.Metrics;
import aima.core.search.framework.NodeFactory;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.QuestaoaAtividade02Base;
import br.ufs.dcomp.eduard6.disciplinas.ia.common.questao.QuestaoExecutavel;

public class QuestaoIDS extends QuestaoaAtividade02Base {

	@Override
	public String getNome() {
		return "Questao 3.4.3 - Iterative-Deeping Search";
	}
	
	private void caixeiroViajante() {
		System.out.println("Problema do caxeiro viajante: ");
		
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);

		String agentLoc = SimplifiedRoadMapOfRomania.ARAD;
		String destination = SimplifiedRoadMapOfRomania.BUCHAREST;

		SearchForActions<String, MoveToAction> search;
		
		search = new IterativeDeepeningSearch<String, MoveToAction>(); /* Tipo de busca */

		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		System.out.println("Custo: " + search.getMetrics().toString());
	}
	
	private void Rainhas() {
		System.out.println("Problema das 8 Rainhas: ");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(8);
		SearchForActions<NQueensBoard, QueenAction> search = new IterativeDeepeningSearch<>(new NodeFactory<>());
		search.findActions(problem);
		System.out.println("Custo: " + search.getMetrics().toString());
	}
	
	private void quebraCabeca() {
		System.out.println("Problema do Quebra Cabeca: ");
		
		EightPuzzleBoard boardWithThreeMoveSolution =
				new EightPuzzleBoard(new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });
		
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(boardWithThreeMoveSolution);
		SearchForActions<EightPuzzleBoard, Action> search = new IterativeDeepeningSearch<EightPuzzleBoard, Action>();
		search.findActions(problem);
		System.out.println("Custo: " + search.getMetrics().toString());
	}

	@Override
	public Metrics problemaDoCaixeiroViajante() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Metrics problemaDas8Rainhas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Metrics problemaDoQuebraCabeca() {
		// TODO Auto-generated method stub
		return null;
	}
}
