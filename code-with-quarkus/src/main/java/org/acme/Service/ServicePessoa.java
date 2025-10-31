package org.acme.Service;

import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPessoa;
import org.acme.Repository.RepositoryPessoa;

import java.sql.SQLException;

public class ServicePessoa {

    @Inject
    RepositoryPessoa repositoryPessoa;

    public boolean inserirPessoa(DTOPessoa pessoa) throws SQLException {
        if (pessoa.getNm_pessoa().isEmpty()){
            return false;
        }
        else if (pessoa.getCpf().isEmpty()){
            return false;
        }
        repositoryPessoa.inserirPessoa(pessoa);
        return true;
        //regras de negócio
    }
}
