package org.acme.Model.DTOs.Funcionarios;

public class DTOLoginFuncionario {
    private String user_dashboard;
    private String password_dashtech;
    private DTOFuncionario funcionario;

    public DTOLoginFuncionario(String user_dashboard, String password_dashtech, DTOFuncionario funcionario) {
        this.user_dashboard = user_dashboard;
        this.password_dashtech = password_dashtech;
        this.funcionario = funcionario;
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

    public DTOFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(DTOFuncionario funcionario) {
        this.funcionario = funcionario;
    }
}
