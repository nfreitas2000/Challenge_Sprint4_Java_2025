package org.acme.Model.DTOs.Pacientes;

public class DTOLoginPaciente {
    private String nm_usuario;
    private String senha;
    private int id_paciente;

    public DTOLoginPaciente(String nm_usuario, String senha, int id_paciente) {
        this.nm_usuario = nm_usuario;
        this.senha = senha;
        this.id_paciente = id_paciente;
    }

    public String getNm_usuario() {
        return nm_usuario;
    }

    public void setNm_usuario(String nm_usuario) {
        this.nm_usuario = nm_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
}
