package org.acme.Model;

public class ModelLoginFuncionario {
    private int id_login_dashtech;
    private String user_dashboard;
    private String password_dashtech;
    private ModelFuncionario funcionario;

    public ModelLoginFuncionario(int id_login_dashtech, String user_dashboard, String password_dashtech, ModelFuncionario funcionario) {
        this.id_login_dashtech = id_login_dashtech;
        this.user_dashboard = user_dashboard;
        this.password_dashtech = password_dashtech;
        this.funcionario = funcionario;
    }

    public int getId_login_dashtech() {
        return id_login_dashtech;
    }

    public void setId_login_dashtech(int id_login_dashtech) {
        this.id_login_dashtech = id_login_dashtech;
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

    public ModelFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ModelFuncionario funcionario) {
        this.funcionario = funcionario;
    }
}
