package cursojava.executavel;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		Aluno aluno1 = new Aluno();
		
		aluno1.setNome("João da Silva");
		
		System.out.println("Aluno: " + aluno1.getNome());
	}

}
