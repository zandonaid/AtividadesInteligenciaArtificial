package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.launcher;

import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.QuestaoaAtividade03Base;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade03.questoes.simulatedannealin.QuestaoSimulatedAnnealing;

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
		List<QuestaoaAtividade03Base> listaDeQuestoes = new ArrayList<>(10);
		
		//Adicionar aqui as questões da atividade.
		listaDeQuestoes.add(new QuestaoSimulatedAnnealing());
		
		System.out.println("-------------------------- Execução da Atividade 03 ---------------------------\n");
		listaDeQuestoes.forEach(q -> {
			System.out.println("QUESTÃO -> " + q.getNome() + ":");
			q.execute();
			System.out.println();
		});
	}
}

