package org.acme.Model.DTOs.Pacientes;

public class DTOPacienteDelete {
    public int idLoginPaciente;
    public int idPaciente;
    public int idPessoa;

    public DTOPacienteDelete(int idLoginPaciente, int idPaciente, int idPessoa) {
        this.idLoginPaciente = idLoginPaciente;
        this.idPaciente = idPaciente;
        this.idPessoa = idPessoa;
    }

    public int getIdLoginPaciente() {
        return idLoginPaciente;
    }

    public void setIdLoginPaciente(int idLoginPaciente) {
        this.idLoginPaciente = idLoginPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
}
