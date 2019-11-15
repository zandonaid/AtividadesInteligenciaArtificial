package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.launcher;

import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02.bfs.QuestaoBFS;
import br.ufs.dcomp.eduard6.disciplinas.ia.common.questao.QuestaoExecutavel;

public class Launcher {
	/**
	 * @author Eduardo Fillipe da Silva Reis
	 * 
	 * Ponto de início da atividade.
	 */
	public static void main(String[] args) {
		List<QuestaoExecutavel> listaDeQuestoes = new ArrayList<>(10);
		
		listaDeQuestoes.add(new QuestaoBFS());
		
		System.out.println("---- Execução da Atividade 02 ----\n");
		listaDeQuestoes.forEach(q -> {
			System.out.println("QUESTÃO -> " + q.getNome() + ":");
			q.execute();
			System.out.println();
		});
	}
}
