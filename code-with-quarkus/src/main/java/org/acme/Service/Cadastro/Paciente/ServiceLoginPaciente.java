package org.acme.Service.Cadastro.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOLoginPaciente;
import org.acme.Repository.Paciente.RepositoryContaPaciente;

import java.sql.SQLException;

@ApplicationScoped
public class ServiceLoginPaciente {
    @Inject
    RepositoryContaPaciente repositoryContaPaciente;

    public boolean validacao(DTOLoginPaciente loginPaciente) throws SQLException {
        if (loginPaciente==null){
            throw new IllegalArgumentException("Dados não recebidos");
        }
        if (loginPaciente.getNm_usuario().isEmpty() ){
            throw new IllegalArgumentException("Nome de usuário inválido (Vazio)");
        }
        if (loginPaciente.getSenha().isEmpty() ){
            throw new IllegalArgumentException("Senha inválida");
        }
        return true;
    }
}
