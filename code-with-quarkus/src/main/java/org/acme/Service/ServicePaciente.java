package org.acme.Service;


import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPessoa;
import org.acme.Model.DTOs.Pacientes.DTOPaciente;
import org.acme.Repository.RepositoryPaciente;

import java.sql.SQLException;

public class ServicePaciente {
    @Inject
    RepositoryPaciente repositoryPaciente;

    public boolean validacao(DTOPaciente paciente) throws SQLException {
        if (paciente==null|| paciente.getGrupo_sanguineo().isEmpty() ){
            throw new IllegalArgumentException("GrupoSanguineo incorreto");
        }
        if (paciente==null|| paciente.getAltura() == 0 ){
            throw new IllegalArgumentException("Altura incorreto");
        }
        if (paciente==null|| paciente.getPeso() == 0 ){
            throw new IllegalArgumentException("Peso incorreto");
        }
        return true;
    }

    public void inserir(DTOPaciente paciente) throws SQLException {
        //validação
        if (validacao(paciente)){
            repositoryPaciente.inserirPessoa(paciente);
        }
        else {
            System.out.println("Erro");
        }


    }
}
