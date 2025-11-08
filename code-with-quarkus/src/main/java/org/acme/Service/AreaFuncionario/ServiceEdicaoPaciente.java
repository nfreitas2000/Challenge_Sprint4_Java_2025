package org.acme.Service.AreaFuncionario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPacienteFull;
import org.acme.Repository.Paciente.RepositoryContaPaciente;
import org.acme.Repository.Paciente.RepositoryPaciente;
import org.acme.Repository.RepositoryPessoa;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ServiceEdicaoPaciente {
    @Inject
    RepositoryPaciente repositoryPaciente;
    @Inject
    RepositoryPessoa repositoryPessoa;
    @Inject
    RepositoryContaPaciente repositoryContaPaciente;

    public List<DTOPacienteFull> listar() throws SQLException {
        return repositoryPaciente.listarPacientesCompletos();
    }

    public boolean deletarConta(int idLoginPaciente, int idPaciente, int idPessoa) throws SQLException{
        try {
            repositoryContaPaciente.removerContaPaciente(idLoginPaciente);
            repositoryPaciente.removerPaciente(idPaciente);
            repositoryPessoa.removerPessoa(idPessoa);
            return true;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public DTOPacienteFull retornaPorId(int id) throws SQLException {
        return repositoryContaPaciente.recuperarPorID(id);
    }

    public boolean atualizar(DTOPacienteFull pacienteFull) throws SQLException {
        try{
            repositoryContaPaciente.atualizar(pacienteFull);
            return true;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
