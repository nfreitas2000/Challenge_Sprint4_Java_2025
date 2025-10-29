package org.acme.Model;

public class ModelPaciente {
    int id_paciente;
    String historico_medico;
    String grupo_sanguineo;
    double altura;
    double peso;
    int id_pessoa;

    public ModelPaciente(int id_paciente, String historico_medico, String grupo_sanguineo, double altura, double peso, int id_pessoa) {
        this.id_paciente = id_paciente;
        this.historico_medico = historico_medico;
        this.grupo_sanguineo = grupo_sanguineo;
        this.altura = altura;
        this.peso = peso;
        this.id_pessoa = id_pessoa;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getHistorico_medico() {
        return historico_medico;
    }

    public void setHistorico_medico(String historico_medico) {
        this.historico_medico = historico_medico;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
}
