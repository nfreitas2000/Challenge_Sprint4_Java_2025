package org.acme.Model.DTOs.Funcionarios;

import org.acme.Model.DTOs.DTOPessoa;

public class DTOFuncionario {
    private String setor;
    private String cargo;
    private String st_credencial;
    private DTOPessoa pessoa;


    public DTOFuncionario(String setor, String cargo, String st_credencial, DTOPessoa pessoa) {
        this.setor = setor;
        this.cargo = cargo;
        this.st_credencial = st_credencial;
        this.pessoa = pessoa;
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

    public DTOPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(DTOPessoa pessoa) {
        this.pessoa = pessoa;
    }
}
