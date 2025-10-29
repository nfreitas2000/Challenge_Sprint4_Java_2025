package org.acme.Model;

public class ModelPessoa {
    int id_pessoa;
    String nm_pessoa;
    String cpf;
    String rg;
    String dt_nascimento;
    String sx_pessoa;
    String estado_civil;
    String escolaridade;

    public ModelPessoa(int id_pessoa, String nm_pessoa, String cpf, String rg, String dt_nascimento, String sx_pessoa, String estado_civil, String escolaridade) {
        this.id_pessoa = id_pessoa;
        this.nm_pessoa = nm_pessoa;
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nascimento = dt_nascimento;
        this.sx_pessoa = sx_pessoa;
        this.estado_civil = estado_civil;
        this.escolaridade = escolaridade;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNm_pessoa() {
        return nm_pessoa;
    }

    public void setNm_pessoa(String nm_pessoa) {
        this.nm_pessoa = nm_pessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSx_pessoa() {
        return sx_pessoa;
    }

    public void setSx_pessoa(String sx_pessoa) {
        this.sx_pessoa = sx_pessoa;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
}
