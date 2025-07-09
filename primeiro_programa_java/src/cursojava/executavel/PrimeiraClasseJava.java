package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a senha");

		if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {
			List<Aluno> alunos = new ArrayList<Aluno>();

			/*
			 * É uma lista que dentro dela temos uma chave que identifica uma sequencia de
			 * valores
			 */
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			String quantidadeAlunos = JOptionPane.showInputDialog("Quantos alunos deseja adicionar?");

			for (int i = 1; i <= Integer.valueOf(quantidadeAlunos); i++) {
				String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + i + " ?");
				/*
				 * String idade = JOptionPane.showInputDialog("Qual a idade?"); String
				 * dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento?");
				 * String registroGeral = JOptionPane.showInputDialog("Qual o RG?"); String
				 * numeroCpf = JOptionPane.showInputDialog("Qual o CPF?"); String nomeMae =
				 * JOptionPane.showInputDialog("Qual o nome da Mãe?"); String nomePai =
				 * JOptionPane.showInputDialog("Qual o nome da Pai?"); String dataMatricula =
				 * JOptionPane.showInputDialog("Qual a data da matrícula?"); String nomeEscola =
				 * JOptionPane.showInputDialog("Qual o nome da escola?"); String
				 * serieMatriculado = JOptionPane.showInputDialog("Qual a série?");
				 */

				Aluno aluno1 = new Aluno();

				aluno1.setNome(nome);
				/*
				 * aluno1.setIdade(Integer.valueOf(idade));
				 * aluno1.setDataNascimento(dataNascimento);
				 * aluno1.setRegistroGeral(registroGeral); aluno1.setNumeroCpf(numeroCpf);
				 * aluno1.setNomeMae(nomeMae); aluno1.setNomePai(nomePai);
				 * aluno1.setDataMatricula(dataMatricula); aluno1.setNomeEscola(nomeEscola);
				 * aluno1.setSerieMatriculado(serieMatriculado);
				 */

				String quantidadeDisciplinas = JOptionPane.showInputDialog("Quantas disciplinas deseja adicionar? ");

				for (int j = 1; j <= Integer.valueOf(quantidadeDisciplinas); j++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Informe o nome da disciplina " + j + "?");
					String notaDisciplina = JOptionPane.showInputDialog("Informe a nota da disciplina " + j + "?");

					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno1.getDisciplinas().add(disciplina);

					if (j < Integer.valueOf(quantidadeDisciplinas)) {
						int maisUma = JOptionPane.showConfirmDialog(null, "Deseja adicionar a próxima disciplina?");
						if (maisUma == 1) {
							break;
						}
					}
				}

				/*
				 * int escolha = JOptionPane.showConfirmDialog(null,
				 * "Deseja remover alguma disciplina?");
				 * 
				 * if (escolha == 0) {
				 * 
				 * int continuarRemover = 0; int posicao = 1; while (continuarRemover == 0) {
				 * String disciplinaRemover =
				 * JOptionPane.showInputDialog("Qual a disciplina deseja remover?");
				 * aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue()
				 * - posicao); posicao++; continuarRemover = JOptionPane.showConfirmDialog(null,
				 * "Continuar a remover?"); }
				 * 
				 * }
				 */
				alunos.add(aluno1);
			}

			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {
				if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}

			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				JOptionPane.showMessageDialog(null,
						"------------------- Lista dos alunos Aprovados -------------------" + "\nResultado: O aluno "
								+ aluno.getNome() + " está " + aluno.getAlunoAprovado2() + ", com média de "
								+ aluno.getMediaNota(),
						"", JOptionPane.INFORMATION_MESSAGE);
			}
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				JOptionPane.showMessageDialog(null,
						"------------------- Lista dos alunos em Recuperação -------------------"
								+ "\nResultado: O aluno " + aluno.getNome() + " está em " + aluno.getAlunoAprovado2()
								+ ", com média de " + aluno.getMediaNota(),
						"", JOptionPane.WARNING_MESSAGE);
			}
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				JOptionPane.showMessageDialog(null,
						"------------------- Lista dos alunos Reprovados -------------------" + "\nResultado: O aluno "
								+ aluno.getNome() + " está " + aluno.getAlunoAprovado2() + ", com média de "
								+ aluno.getMediaNota(),
						"", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Acesso não permitido.", "Autenticação", JOptionPane.ERROR_MESSAGE);
		}

	}

}
