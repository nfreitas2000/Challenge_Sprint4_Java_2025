package org.acme.Model.DTOs.Funcionarios;

import io.vertx.codegen.Model;
import org.acme.Model.ModelFuncionario;

public class DTOLoginFuncionario {
    private String nm_usuario;
    private String senha;
    private ModelFuncionario funcionario;

    public DTOLoginFuncionario(String nm_usuario, String senha, ModelFuncionario funcionario) {
        this.nm_usuario = nm_usuario;
        this.senha = senha;
        this.funcionario = funcionario;
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

    public ModelFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ModelFuncionario funcionario) {
        this.funcionario = funcionario;
    }
}
