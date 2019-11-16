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
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.QuestaoaAtividade02Base;

/**
 * @author Eduardo Fillipe da Silva Reis
 * 
 * Questão 3.4.1 Breadth-first search.
 */
public class QuestaoBFS extends QuestaoaAtividade02Base {

	@Override
	public String getNome() {
		return "Questão 1 - Breadth-first search";
	}
	
	@Override
	public void problemaDoCaixeiroViajante() {
		System.out.println("Problema do caxeiro viajante: ");
		
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);

		String agentLoc = QuestaoaAtividade02Base.CAIXEIRO_VIAJANTE_ORIGEM;
		String destination = QuestaoaAtividade02Base.CAIXEIRO_VIAJANTE_ORIGEM_DESTINO;

		SearchForActions<String, MoveToAction> search;
		search = new BreadthFirstSearch<String, MoveToAction>();

		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		System.out.println("Custo: " + search.getMetrics().toString());
	}
	
	@Override
	public void problemaDas8Rainhas() {
		System.out.println("Problema das 8 Rainhas: ");

		Problem<NQueensBoard, QueenAction> problem = QuestaoaAtividade02Base.OITO_RAINHAS_PROBLEM;
		SearchForActions<NQueensBoard, QueenAction> search = new BreadthFirstSearch<>(new GraphSearch<>());
		search.findActions(problem);
		System.out.println("Custo: " + search.getMetrics().toString());
	}
	
	@Override
	public void problemaDoQuebraCabeca() {
		System.out.println("Problema do Quebra Cabeça: ");
		
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(QuestaoaAtividade02Base.QUEBRA_CABECA_TABULEIRO);
		SearchForActions<EightPuzzleBoard, Action> search = new BreadthFirstSearch<EightPuzzleBoard, Action>();
		search.findActions(problem);
		System.out.println("Custo: " + search.getMetrics().toString());
	}
}
