package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.atividade02;

import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.map.SimplifiedRoadMapOfRomania;
import aima.core.environment.nqueens.NQueensBoard;
import aima.core.environment.nqueens.NQueensFunctions;
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.problem.Problem;
import br.ufs.dcomp.eduard6.disciplinas.ia.common.questao.QuestaoExecutavel;


/**
 * @author Eduardo Fillipe da Silva Reis
 * 
 * Classe responsável pela configuração de tipos da atividade 2, para garantir que todos os testes
 * sejam iguais entre as questões.
 */
public abstract class QuestaoaAtividade02Base extends QuestaoExecutavel {
	
	/**
	 * Contante de configuração do problema das oito rainhas. 
	 * Descrição incremental do problema, inicialmente vazio.
	 */
	public static Problem<NQueensBoard, QueenAction> OITO_RAINHAS_PROBLEM = NQueensFunctions.createIncrementalFormulationProblem(8);
	/**
	 * Origem no problema do caxeiro viajante. 
	 * 
	 */
	public static String CAIXEIRO_VIAJANTE_ORIGEM = SimplifiedRoadMapOfRomania.ARAD;
	/**
	 * Destino no problema do caxeiro viajante. 
	 * 
	 */
	public static String CAIXEIRO_VIAJANTE_ORIGEM_DESTINO = SimplifiedRoadMapOfRomania.BUCHAREST;
	/**
	 * Tabuleiro inicial do problema do quebra cabeças. Pode ser resolvido em 3 movimentos. 
	 * 
	 */
	public static EightPuzzleBoard QUEBRA_CABECA_TABULEIRO = new EightPuzzleBoard(new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });
	
	public abstract void problemaDoCaixeiroViajante();
	
	public abstract void problemaDas8Rainhas();
	
	public abstract void problemaDoQuebraCabeca();
	
	@Override
	public void execute() {
		this.problemaDoCaixeiroViajante();
		System.out.println();
		this.problemaDas8Rainhas();
		System.out.println();
		this.problemaDoQuebraCabeca();
	}
}
