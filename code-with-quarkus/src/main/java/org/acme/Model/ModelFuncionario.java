package org.acme.Model;

public class ModelFuncionario {
    private int id_funcionario;
    private String setor;
    private String cargo;
    private String st_credencial;
    private ModelPessoa pessoa;

    public ModelFuncionario(int id_funcionario, String setor, String cargo, String st_credencial, ModelPessoa pessoa) {
        this.id_funcionario = id_funcionario;
        this.setor = setor;
        this.cargo = cargo;
        this.st_credencial = st_credencial;
        this.pessoa = pessoa;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSt_credencial() {
        return st_credencial;
    }

    public void setSt_credencial(String st_credencial) {
        this.st_credencial = st_credencial;
    }

    public ModelPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(ModelPessoa pessoa) {
        this.pessoa = pessoa;
    }
}
