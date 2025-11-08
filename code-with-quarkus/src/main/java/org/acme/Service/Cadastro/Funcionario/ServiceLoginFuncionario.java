package org.acme.Service.Cadastro.Funcionario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Funcionarios.DTOContaFuncionario;
import org.acme.Model.DTOs.Funcionarios.DTOLoginFuncionario;
import org.acme.Model.ModelLoginFuncionario;
import org.acme.Repository.Funcionario.RepositoryContaFuncionario;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ServiceLoginFuncionario {
    @Inject
    RepositoryContaFuncionario repositoryContaFuncionario;

    public boolean validacao(DTOLoginFuncionario loginFuncionario) throws SQLException {
        if (loginFuncionario==null){
            throw new IllegalArgumentException("Dados não recebidos");
        }
        if (loginFuncionario.getNm_usuario().isEmpty() ){
            throw new IllegalArgumentException("Nome de usuário inválido (Vazio)");
        }
        if (loginFuncionario.getSenha().isEmpty() ){
            throw new IllegalArgumentException("Senha inválida");
        }
        return true;
    }

    public boolean validacaoLoginFuncionario(DTOContaFuncionario conta) throws SQLException {
        List<DTOContaFuncionario> l = repositoryContaFuncionario.listarLogins();

        for (DTOContaFuncionario contas:l){
            if (contas.getUsuario().equals(conta.getUsuario()) && contas.getSenha().equals(conta.getSenha())){
                return true;
            }
        }

        return false;
    }
}
