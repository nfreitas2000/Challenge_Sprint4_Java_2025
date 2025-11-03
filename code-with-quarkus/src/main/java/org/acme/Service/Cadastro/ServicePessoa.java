package org.acme.Service.Cadastro;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPessoa;
import org.acme.Repository.RepositoryPessoa;

import java.sql.SQLException;

@ApplicationScoped
public class ServicePessoa {

    @Inject
    RepositoryPessoa repositoryPessoa;

    public boolean validacao(DTOPessoa pessoa) throws SQLException {
        if (pessoa==null){
            throw new IllegalArgumentException("Dados de pessoa não recebidos");
        }
        if (pessoa.getNm_pessoa().isEmpty() ){
            throw new IllegalArgumentException("Nome inválido");
        }
        if (pessoa.getCpf().isEmpty() ){
            throw new IllegalArgumentException("CPF inválido");
        }
        if (pessoa.getRg().isEmpty() ){
            throw new IllegalArgumentException("RG inválido");
        }
        if (pessoa.getDt_nascimento().isEmpty() ){
            throw new IllegalArgumentException("Data inválida");
        }
        if (pessoa.getSx_pessoa().isEmpty() ){
            throw new IllegalArgumentException("Sexo inválido");
        }
        if (pessoa.getEstado_civil().isEmpty() ){
            throw new IllegalArgumentException("Estado civil inválido");
        }
        if (pessoa.getEscolaridade().isEmpty() ){
            throw new IllegalArgumentException("Escolaridade inválida");
        }
        return true;
    }

    public void inserir(DTOPessoa pessoa) throws SQLException {
        //validação
        if (validacao(pessoa)){
            repositoryPessoa.inserirPessoa(pessoa);
        }
        else {
            System.out.println("Erro");
        }


    }
}
