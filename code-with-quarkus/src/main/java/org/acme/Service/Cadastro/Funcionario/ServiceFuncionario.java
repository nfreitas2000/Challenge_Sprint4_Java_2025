package org.acme.Service.Cadastro.Funcionario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Funcionarios.DTOFuncionario;
import org.acme.Model.DTOs.Pacientes.DTOPaciente;
import org.acme.Repository.Funcionario.RepositoryFuncionario;
import org.acme.Repository.Paciente.RepositoryPaciente;

import java.sql.SQLException;

@ApplicationScoped
public class ServiceFuncionario {

    public boolean validacao(DTOFuncionario funcionario) throws SQLException {
        if (funcionario==null){
            throw new IllegalArgumentException("Dados não recebidos");
        }
        if (funcionario.getSetor().isEmpty() ){
            throw new IllegalArgumentException("Setor inválido");
        }
        if (funcionario.getCargo().isEmpty() ){
            throw new IllegalArgumentException("Cargo inválido");
        }
        if (funcionario.getSt_credencial().isEmpty() ){
            throw new IllegalArgumentException("Status da Credencial inválido");
        }
        return true;
    }
}
