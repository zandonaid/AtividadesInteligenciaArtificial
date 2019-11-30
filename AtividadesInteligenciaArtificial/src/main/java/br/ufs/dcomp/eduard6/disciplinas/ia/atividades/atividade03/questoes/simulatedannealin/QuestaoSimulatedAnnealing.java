package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.simulatedannealin;

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
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.problem.Problem;
import aima.core.search.local.Scheduler;
import aima.core.search.local.SimulatedAnnealingSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.QuestaoaAtividade03Base;
/**
 * 
 * @author Eduardo Fillipe da Silva Reis
 * 
 * Questão 4.1.2 Simulated annealing
 *
 */
public class QuestaoSimulatedAnnealing extends QuestaoaAtividade03Base {

	@Override
	public Metrics problemaDoCaixeiroViajante() {
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);

		String agentLoc = SimplifiedRoadMapOfRomania.ARAD;
		String destination = SimplifiedRoadMapOfRomania.BUCHAREST;

		SimulatedAnnealingSearch<String, MoveToAction> search;
		search = new SimulatedAnnealingSearch<String, MoveToAction>(new ToDoubleFunction<Node<String, MoveToAction>>() {
			public double applyAsDouble(Node<String, MoveToAction> arg0) {
				return MapFunctions.getSLD(arg0.getState(), destination, map);
			};
		}, new Scheduler(20, 0.045, 100));
		
		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		System.out.println(search.getLastState());
		return search.getMetrics();
	}

	@Override
	public Metrics problemaDas8Rainhas() {
		Problem<NQueensBoard, QueenAction> problema = QuestaoaAtividade03Base.OITO_RAINHAS_COMPLETE_PROBLEM;
		
		SimulatedAnnealingSearch<NQueensBoard, QueenAction> search =
				new SimulatedAnnealingSearch<>(new ToDoubleFunction<Node<NQueensBoard, QueenAction>>() {
					@Override
					public double applyAsDouble(Node<NQueensBoard, QueenAction> arg0) {
						return NQueensFunctions.getNumberOfAttackingPairs(arg0);
					}
				}, new Scheduler(20, 0.045, 10000));
		
		search.findActions(problema);
		return search.getMetrics();
	}

	@Override
	public Metrics problemaDoQuebraCabeca() {
		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(QuestaoaAtividade03Base.QUEBRA_CABECA_TABULEIRO);
		SimulatedAnnealingSearch<EightPuzzleBoard, Action> search = new SimulatedAnnealingSearch<>
				(new ToDoubleFunction<Node<EightPuzzleBoard, Action>>() {
					@Override
					public double applyAsDouble(Node<EightPuzzleBoard, Action> arg0) {
						return EightPuzzleFunctions.getManhattanDistance(arg0);
					}
				}, new Scheduler(20, 0.045, 10000));
		search.findNode(problem);
		return search.getMetrics();
	}

	@Override
	public String getNome() {
		return "Questão 4.1.2 - Simulated Annealing";
	}
}
