package org.acme.Model.DTOs.Funcionarios;

public class DTOLoginFuncionario {
    private String user_dashboard;
    private String password_dashtech;
    private int id_funcionario;

    public DTOLoginFuncionario(String user_dashboard, String password_dashtech, int id_funcionario) {
        this.user_dashboard = user_dashboard;
        this.password_dashtech = password_dashtech;
        this.id_funcionario = id_funcionario;
    }

    public String getUser_dashboard() {
        return user_dashboard;
    }

    public void setUser_dashboard(String user_dashboard) {
        this.user_dashboard = user_dashboard;
    }

    public String getPassword_dashtech() {
        return password_dashtech;
    }

    public void setPassword_dashtech(String password_dashtech) {
        this.password_dashtech = password_dashtech;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
}
