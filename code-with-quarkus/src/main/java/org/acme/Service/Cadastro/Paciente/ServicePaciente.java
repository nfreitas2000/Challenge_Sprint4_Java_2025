package org.acme.Service.Cadastro.Paciente;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOPaciente;
import org.acme.Repository.Paciente.RepositoryPaciente;

import java.sql.SQLException;

@ApplicationScoped
public class ServicePaciente {
    @Inject
    RepositoryPaciente repositoryPaciente;

    public boolean validacao(DTOPaciente paciente) throws SQLException {
        if (paciente==null){
            throw new IllegalArgumentException("Dados não recebidos");
        }
        if (paciente.getGrupo_sanguineo().isEmpty() ){
            throw new IllegalArgumentException("Grupo Sanguineo inválido");
        }
        if (paciente.getAltura() == 0 ){
            throw new IllegalArgumentException("Altura inválida");
        }
        if (paciente.getPeso() == 0 ){
            throw new IllegalArgumentException("Peso inválida");
        }
        return true;
    }

}
