package org.acme.Service.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOContaPaciente;
import org.acme.Model.DTOs.Pacientes.DTOLoginPaciente;
import org.acme.Repository.Paciente.RepositoryContaPaciente;

import java.sql.SQLException;
import java.util.List;

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

    public boolean validacaoLoginPaciente(DTOContaPaciente conta) throws SQLException {
        List<DTOContaPaciente> l = repositoryContaPaciente.listarLogins();

        for (DTOContaPaciente contas:l){
            if (contas.getUsuario().equals(conta.getUsuario()) && contas.getSenha().equals(conta.getSenha())){
                return true;
            }
        }
        return false;
    }
}
