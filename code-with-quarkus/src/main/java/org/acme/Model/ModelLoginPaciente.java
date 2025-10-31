package org.acme.Model;

public class ModelLoginPaciente {
    private int id_login_paciente;
    private String nm_usuario;
    private String senha;
    private ModelPaciente paciente;

    public ModelLoginPaciente(int id_login_paciente, String nm_usuario, String senha, ModelPaciente paciente) {
        this.id_login_paciente = id_login_paciente;
        this.nm_usuario = nm_usuario;
        this.senha = senha;
        this.paciente = paciente;
    }

    public int getId_login_paciente() {
        return id_login_paciente;
    }

    public void setId_login_paciente(int id_login_paciente) {
        this.id_login_paciente = id_login_paciente;
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
