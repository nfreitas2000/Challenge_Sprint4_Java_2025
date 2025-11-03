package org.acme.Service.Cadastro.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOPacienteCompleto;
import org.acme.Repository.Paciente.RepositoryContaPaciente;
import org.acme.Repository.Paciente.RepositoryPaciente;
import org.acme.Repository.RepositoryPessoa;
import org.acme.Service.Cadastro.ServicePessoa;

import java.sql.SQLException;

@ApplicationScoped
public class ServicePacienteCompleto {
    @Inject
    RepositoryPessoa repositoryPessoa;
    @Inject
    RepositoryPaciente repositoryPaciente;
    @Inject
    RepositoryContaPaciente repositoryContaPaciente;
    @Inject
    ServicePessoa servicePessoa;
    @Inject
    ServicePaciente servicePaciente;
    @Inject
    ServiceLoginPaciente serviceLoginPaciente;

    public void criar(DTOPacienteCompleto pacienteCompleto) throws SQLException {
        if (servicePessoa.validacao(pacienteCompleto.getPessoa())){
            if (servicePaciente.validacao(pacienteCompleto.getPaciente())){
                if (serviceLoginPaciente.validacao(pacienteCompleto.getLogin())){
                    pacienteCompleto.getPessoa().setRg(pacienteCompleto.getPessoa().getRg().substring(0, 2) + "." + pacienteCompleto.getPessoa().getRg().substring(2, 5) + "." + pacienteCompleto.getPessoa().getRg().substring(5, 8) + "-" + pacienteCompleto.getPessoa().getRg().substring(8));
                    pacienteCompleto.getPessoa().setCpf(pacienteCompleto.getPessoa().getCpf().substring(0, 3) + "." + pacienteCompleto.getPessoa().getCpf().substring(3, 6) + "." + pacienteCompleto.getPessoa().getCpf().substring(6, 9) + "-" + pacienteCompleto.getPessoa().getCpf().substring(9));
                    repositoryPessoa.inserirPessoa(pacienteCompleto.getPessoa());
                    pacienteCompleto.getPaciente().setPessoa(repositoryPessoa.recuperarPessoa(pacienteCompleto.getPessoa().getCpf()));
                    repositoryPaciente.inserirPessoa(pacienteCompleto.getPaciente());
                    pacienteCompleto.getLogin().setPaciente(repositoryPaciente.recuperarPaciente(pacienteCompleto.getPaciente()));
                    repositoryContaPaciente.inserirPessoa(pacienteCompleto.getLogin());
                }
            }
        }
    }
}
