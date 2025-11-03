package org.acme.Model.DTOs.Pacientes;

import org.acme.Model.DTOs.DTOPessoa;

public class DTOPacienteCompleto {

    private DTOPessoa pessoa;
    private DTOPaciente paciente;
    private DTOLoginPaciente login;

    public DTOPessoa getPessoa() { return pessoa; }
    public void setPessoa(DTOPessoa pessoa) { this.pessoa = pessoa; }

    public DTOPaciente getPaciente() { return paciente; }
    public void setPaciente(DTOPaciente paciente) { this.paciente = paciente; }

    public DTOLoginPaciente getLogin() { return login; }
    public void setLogin(DTOLoginPaciente login) { this.login = login; }
}
