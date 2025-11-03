package org.acme.Service.Cadastro.Funcionario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Funcionarios.DTOFuncionarioCompleto;
import org.acme.Model.DTOs.Pacientes.DTOPacienteCompleto;
import org.acme.Repository.Funcionario.RepositoryContaFuncionario;
import org.acme.Repository.Funcionario.RepositoryFuncionario;
import org.acme.Repository.Paciente.RepositoryContaPaciente;
import org.acme.Repository.Paciente.RepositoryPaciente;
import org.acme.Repository.RepositoryPessoa;
import org.acme.Service.Cadastro.Paciente.ServiceLoginPaciente;
import org.acme.Service.Cadastro.Paciente.ServicePaciente;
import org.acme.Service.Cadastro.ServicePessoa;

import java.sql.SQLException;

@ApplicationScoped
public class ServiceFuncionarioCompleto {
    @Inject
    RepositoryPessoa repositoryPessoa;
    @Inject
    RepositoryFuncionario repositoryFuncionario;
    @Inject
    RepositoryContaFuncionario repositoryContaFuncionario;
    @Inject
    ServicePessoa servicePessoa;
    @Inject
    ServiceFuncionario serviceFuncionario;
    @Inject
    ServiceLoginFuncionario serviceLoginFuncionario;

    public void criar(DTOFuncionarioCompleto funcionarioCompleto) throws SQLException {
        if (servicePessoa.validacao(funcionarioCompleto.getPessoa())){
            if (serviceFuncionario.validacao(funcionarioCompleto.getFuncionario())){
                if (serviceLoginFuncionario.validacao(funcionarioCompleto.getLogin())){
                    funcionarioCompleto.getPessoa().setRg(funcionarioCompleto.getPessoa().getRg().substring(0, 2) + "." + funcionarioCompleto.getPessoa().getRg().substring(2, 5) + "." + funcionarioCompleto.getPessoa().getRg().substring(5, 8) + "-" + funcionarioCompleto.getPessoa().getRg().substring(8));
                    funcionarioCompleto.getPessoa().setCpf(funcionarioCompleto.getPessoa().getCpf().substring(0, 3) + "." + funcionarioCompleto.getPessoa().getCpf().substring(3, 6) + "." + funcionarioCompleto.getPessoa().getCpf().substring(6, 9) + "-" + funcionarioCompleto.getPessoa().getCpf().substring(9));
                    repositoryPessoa.inserirPessoa(funcionarioCompleto.getPessoa());
                    funcionarioCompleto.getFuncionario().setPessoa(repositoryPessoa.recuperarPessoa(funcionarioCompleto.getPessoa().getCpf()));
                    repositoryFuncionario.inserirPessoa(funcionarioCompleto.getFuncionario());
                    funcionarioCompleto.getLogin().setFuncionario(repositoryFuncionario.recuperarFuncionario(funcionarioCompleto.getFuncionario()));
                    repositoryContaFuncionario.inserirPessoa(funcionarioCompleto.getLogin());
                }
            }
        }
    }
}
