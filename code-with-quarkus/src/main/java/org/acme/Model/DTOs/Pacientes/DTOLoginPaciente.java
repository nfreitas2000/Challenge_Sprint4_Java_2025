package org.acme.Model.DTOs.Pacientes;

import org.acme.Model.ModelPaciente;

public class DTOLoginPaciente {
    private String nm_usuario;
    private String senha;
    private ModelPaciente paciente;

    public DTOLoginPaciente(String nm_usuario, String senha, ModelPaciente paciente) {
        this.nm_usuario = nm_usuario;
        this.senha = senha;
        this.paciente = paciente;
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

    public ModelPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(ModelPaciente paciente) {
        this.paciente = paciente;
    }
}
