package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOPacienteCompleto;
import org.acme.Repository.RepositoryContaPaciente;
import org.acme.Repository.RepositoryPaciente;
import org.acme.Repository.RepositoryPessoa;

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
        System.out.println(pacienteCompleto.getPessoa().getNm_pessoa());
        System.out.println(pacienteCompleto.getPessoa().getNm_pessoa());
        System.out.println(pacienteCompleto.getPessoa().getNm_pessoa());
        System.out.println(pacienteCompleto.getPessoa().getNm_pessoa());
        System.out.println(pacienteCompleto.getPessoa().getNm_pessoa());
        System.out.println(pacienteCompleto.getPessoa().getNm_pessoa());

        repositoryPessoa.inserirPessoa(pacienteCompleto.getPessoa());



    }
}
