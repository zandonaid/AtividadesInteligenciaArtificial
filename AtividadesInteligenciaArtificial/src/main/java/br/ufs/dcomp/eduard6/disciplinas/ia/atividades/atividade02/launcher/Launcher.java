package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.launcher;

import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.QuestaoaAtividade02Base;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.questoes.bfs.QuestaoBFS;
import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.questoes.uniformcost.QuestaoUniformCost;

public class Launcher {
	/**
	 * @author Eduardo Fillipe da Silva Reis
	 * 
	 * Ponto de início da atividade.
	 */
	public static void main(String[] args) {
		List<QuestaoaAtividade02Base> listaDeQuestoes = new ArrayList<>(10);
		
		//Adicionar aqui as questões da atividade.
		listaDeQuestoes.add(new QuestaoBFS());
		listaDeQuestoes.add(new QuestaoUniformCost());
		
		System.out.println("-------------------------- Execução da Atividade 02 ---------------------------\n");
		listaDeQuestoes.forEach(q -> {
			System.out.println("QUESTÃO -> " + q.getNome() + ":");
			q.execute();
			System.out.println();
		});
	}
}
