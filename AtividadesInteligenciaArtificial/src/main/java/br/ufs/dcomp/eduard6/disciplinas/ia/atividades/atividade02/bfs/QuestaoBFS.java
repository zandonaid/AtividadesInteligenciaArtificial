package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.bfs;

import aima.core.agent.Agent;
import aima.core.agent.EnvironmentListener;
import aima.core.agent.impl.DynamicPercept;
import aima.core.agent.impl.SimpleEnvironmentView;
import aima.core.environment.map.ExtendableMap;
import aima.core.environment.map.MapEnvironment;
import aima.core.environment.map.MoveToAction;
import aima.core.environment.map.SimpleMapAgent;
import aima.core.environment.map.SimplifiedRoadMapOfRomania;
import aima.core.search.framework.SearchForActions;
import aima.core.search.uninformed.BreadthFirstSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.common.questao.QuestaoExecutavel;

public class QuestaoBFS extends QuestaoExecutavel {

	@Override
	public void execute() {
		problemaDoCaixeiroViajante();
		problemaDas8Rainhas();
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
		EnvironmentListener<Object, Object> envView = new SimpleEnvironmentView();

		String agentLoc = SimplifiedRoadMapOfRomania.ARAD;
		String destination = SimplifiedRoadMapOfRomania.BUCHAREST;

		SearchForActions<String, MoveToAction> search;
		search = new BreadthFirstSearch<String, MoveToAction>();

		Agent<DynamicPercept, MoveToAction> agent;
		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		envView.notify(search.getMetrics().toString());
	}
	
	private void problemaDas8Rainhas() {
		
	}
	
	private void problemaDoQuebraCabeca() {
		
	}
}
