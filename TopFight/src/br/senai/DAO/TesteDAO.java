package br.senai.DAO;

import br.senai.model.Aluno;
import br.senai.model.Professor;
import java.util.Date;

/**
 *
 * @author André Guilherme
 */
public class TesteDAO {

    AlunoDAO alunoDao = new AlunoDAO();

    public void InserirAluno() {
        Aluno aluno = new Aluno();
        aluno.setDscNome("TesteNome");
        aluno.setDscCEP("TesteCEP");
        aluno.setDscBairro("TesteBairro");
        aluno.setDscComplemento("TesteComplento");
        aluno.setDscEmail("TesteEmail");
        aluno.setDscEndereco("TesteEndereco");
        aluno.setDscObservacao("TesteObs");
        aluno.setDscCPF("TesteCPF");
        aluno.setNunNumero(1);
        aluno.setStatus(2);
        aluno.setSexo(1);
        aluno.setAltura(1.92);
        aluno.setPeso(94.0);
        aluno.setDtDataNasc(new Date());

        alunoDao.inserir(aluno);
    }

    public void ListarAlunos() {
        for (int i = 0; i < alunoDao.listarTodos().size(); i++) {
            System.out.println(alunoDao.listarTodos().get(i).getDscNome() + "\n"
                    + alunoDao.listarTodos().get(i).getNumIdPessoa());
        }
    }
    
    ProfessorDAO professorDao = new ProfessorDAO();

    public void InserirProfessor() {
        Professor professor = new Professor();
        professor.setDscNome("TesteNome");
        professor.setDscCEP("TesteCEP");
        professor.setDscBairro("TesteBairro");
        professor.setDscComplemento("TesteComplento");
        professor.setDscEmail("TesteEmail");
        professor.setDscEndereco("TesteEndereco");
        professor.setDscObservacao("TesteObs");
        professor.setDscCPF("TesteCPF");
        professor.setNunNumero(1);
        professor.setSexo(2);
        professor.setStatus(2);
        professor.setDtDataNasc(new Date());

        professorDao.inserir(professor);
    }

    public void ListarProfessores() {
        for (int i = 0; i < professorDao.listarTodos().size(); i++) {
            System.out.println(professorDao.listarTodos().get(i).getDscNome() + "\n"
                    + professorDao.listarTodos().get(i).getNumIdPessoa());
        }

    }
}
