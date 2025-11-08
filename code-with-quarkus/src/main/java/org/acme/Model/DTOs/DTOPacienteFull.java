package org.acme.Model.DTOs;

public class DTOPacienteFull {
    private int idLoginPaciente;
    private String nmUsuario;
    private String senha;

    private int idPaciente;
    private String historicoMedico;
    private String grupoSanguineo;
    private double altura;
    private double peso;

    private int idPessoa;
    private String nmPessoa;
    private String cpf;
    private String rg;
    private String dtNascimento;
    private String sxPessoa;
    private String estadoCivil;
    private String escolaridade;

    public DTOPacienteFull(int idLoginPaciente, String nmUsuario, String senha, int idPaciente, String historicoMedico, String grupoSanguineo, double altura, double peso, int idPessoa, String nmPessoa, String cpf, String rg, String dtNascimento, String sxPessoa, String estadoCivil, String escolaridade) {
        this.idLoginPaciente = idLoginPaciente;
        this.nmUsuario = nmUsuario;
        this.senha = senha;
        this.idPaciente = idPaciente;
        this.historicoMedico = historicoMedico;
        this.grupoSanguineo = grupoSanguineo;
        this.altura = altura;
        this.peso = peso;
        this.idPessoa = idPessoa;
        this.nmPessoa = nmPessoa;
        this.cpf = cpf;
        this.rg = rg;
        this.dtNascimento = dtNascimento;
        this.sxPessoa = sxPessoa;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
    }

    public int getIdLoginPaciente() { return idLoginPaciente; }
    public void setIdLoginPaciente(int idLoginPaciente) { this.idLoginPaciente = idLoginPaciente; }

    public String getNmUsuario() { return nmUsuario; }
    public void setNmUsuario(String nmUsuario) { this.nmUsuario = nmUsuario; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public String getHistoricoMedico() { return historicoMedico; }
    public void setHistoricoMedico(String historicoMedico) { this.historicoMedico = historicoMedico; }

    public String getGrupoSanguineo() { return grupoSanguineo; }
    public void setGrupoSanguineo(String grupoSanguineo) { this.grupoSanguineo = grupoSanguineo; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public int getIdPessoa() { return idPessoa; }
    public void setIdPessoa(int idPessoa) { this.idPessoa = idPessoa; }

    public String getNmPessoa() { return nmPessoa; }
    public void setNmPessoa(String nmPessoa) { this.nmPessoa = nmPessoa; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public String getDtNascimento() { return dtNascimento; }
    public void setDtNascimento(String dtNascimento) { this.dtNascimento = dtNascimento; }

    public String getSxPessoa() { return sxPessoa; }
    public void setSxPessoa(String sxPessoa) { this.sxPessoa = sxPessoa; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getEscolaridade() { return escolaridade; }
    public void setEscolaridade(String escolaridade) { this.escolaridade = escolaridade; }
}
