package org.acme.Service.AreaFuncionario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPacienteFull;
import org.acme.Repository.Paciente.RepositoryPaciente;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ServiceEdicaoPaciente {
    @Inject
    RepositoryPaciente repositoryPaciente;

    public List<DTOPacienteFull> listar() throws SQLException {
        return repositoryPaciente.listarPacientesCompletos();
    }
}
