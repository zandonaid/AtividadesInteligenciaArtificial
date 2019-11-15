package br.ufs.dcomp.eduard6.disciplinas.ia.common.questao;
/**
 * 
 * @author Eduardo Fillipe da Silva Reis
 * Questão que pode ser executada e gera um saída no console ou interface gráfica.
 */

public abstract class QuestaoExecutavel extends Questao implements IQuestaoExecutavel {

	@Override
	public abstract void execute();

	@Override
	public abstract String getNome();

}
