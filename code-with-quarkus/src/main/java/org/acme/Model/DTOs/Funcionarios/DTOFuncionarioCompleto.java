package org.acme.Model.DTOs.Funcionarios;

import org.acme.Model.DTOs.DTOPessoa;
import org.acme.Model.DTOs.Pacientes.DTOLoginPaciente;

public class DTOFuncionarioCompleto {
    private DTOFuncionario funcionario;
    private DTOLoginFuncionario login;
    private DTOPessoa pessoa;


    public DTOPessoa getPessoa() { return pessoa; }
    public void setPessoa(DTOPessoa pessoa) { this.pessoa = pessoa; }

    public DTOFuncionario getFuncionario() { return funcionario; }
    public void setFuncionario(DTOFuncionario funcionario) { this.funcionario = funcionario; }

    public DTOLoginFuncionario getLogin() { return login; }
    public void setLogin(DTOLoginFuncionario login) { this.login = login; }
}
