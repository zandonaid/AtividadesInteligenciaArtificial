package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.launcher;

import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.QuestaoaAtividade03Base;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.bestfirstsearch.QuestaoBestFirstSearch;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.geneticalgorithm.QuestaoGeneticAlgorithm;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.simulatedannealing.QuestaoSimulatedAnnealing;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.hillclimbingsearch.*;

/**
 * @author Eduardo Fillipe da Silva Reis
 * 
 *  Ponto de início da Atividade 03.
 */
public class Launcher {
	/**
	 * @author Eduardo Fillipe da Silva Reis
	 * 
	 * Ponto de início da atividade 03.
	 */
	public static void main(String[] args) {
		List<QuestaoaAtividade03Base> listaDeQuestoes = new ArrayList<>(8);
		
		//Adicionar aqui as questões da atividade.
		//listaDeQuestoes.add(new QuestaoSimulatedAnnealing());
		//listaDeQuestoes.add(new QuestaoGeneticAlgorithm());
		listaDeQuestoes.add(new QuestaoHillClimbingSearch());
		listaDeQuestoes.add(new QuestaoBestFirstSearch());
		
		
		System.out.println("-------------------------- Execução da Atividade 03 ---------------------------\n");
		listaDeQuestoes.forEach(q -> {
			System.out.println("QUESTÃO -> " + q.getNome() + ":");
			q.execute();
			System.out.println("---------------------------------------------------------------------------\n");
		});
	}
}

