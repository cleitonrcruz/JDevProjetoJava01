package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno");
		
		Diretor diretor = new Diretor();
		diretor.setRegistroGeral("45345433");
		
		Secretario secretario = new Secretario();
		secretario.setExperiencia("Administração");
		
		aluno.pessoaMaiorIdade();

	}

}
