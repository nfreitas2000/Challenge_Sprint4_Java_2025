package org.acme.Service;

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
        if (pessoa==null|| pessoa.getNm_pessoa().isEmpty() ){
            throw new IllegalArgumentException("Nome incorreto");
        }
        if (pessoa==null|| pessoa.getCpf().isEmpty() ){
            throw new IllegalArgumentException("CPF incorreto");
        }
        if (pessoa==null|| pessoa.getRg().isEmpty() ){
            throw new IllegalArgumentException("RG incorreto");
        }
        if (pessoa==null|| pessoa.getDt_nascimento().isEmpty() ){
            throw new IllegalArgumentException("Data incorreta");
        }
        if (pessoa==null|| pessoa.getSx_pessoa().isEmpty() ){
            throw new IllegalArgumentException("Sexo incorreto");
        }
        if (pessoa==null|| pessoa.getEstado_civil().isEmpty() ){
            throw new IllegalArgumentException("Estado civil incorreto");
        }
        if (pessoa==null|| pessoa.getEscolaridade().isEmpty() ){
            throw new IllegalArgumentException("escolaridade incorreto");
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
