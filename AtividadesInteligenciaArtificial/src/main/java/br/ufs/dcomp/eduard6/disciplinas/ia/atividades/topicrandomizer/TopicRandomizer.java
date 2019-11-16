package br.ufs.dcomp.eduard6.disciplinas.ia.atividades.topicrandomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TopicRandomizer {
	/**
	 * @author Eduardo Fillipe da Silva Reis
	 * Classe que divide uma dada atividade entre os integrantes
	 * do grupo.
	 */

	enum Alunos{
        EDUARDO(), FELIPE(), MARIANA(), MATHEUS();
        public String topico;

        private Alunos(String topico) {
            this.topico = topico;
        }
        
        private Alunos() {}
        
        @Override
        public String toString() {
            return this.name() + ": " + this.topico;
        }
    }
    
    public static void main(String[] args) {
        Random rGenerator = new Random();
        ArrayList<String> topicos = new ArrayList<>(Arrays.asList("4.1/1", "4.1/2", "4.2", "4.3"));
        for (Alunos aluno : Alunos.values()) {
            int t = rGenerator.nextInt(topicos.size());
            aluno.topico = topicos.get(t);
            topicos.remove(t);
        }
        System.out.println(Arrays.toString(Alunos.values()));
    }

}
