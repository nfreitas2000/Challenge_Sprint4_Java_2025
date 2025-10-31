package org.acme.Model.DTOs.Pacientes;

import org.acme.Model.DTOs.DTOPessoa;
import org.acme.Model.ModelPessoa;

public class DTOPaciente {
    private String historico_medico;
    private String grupo_sanguineo;
    private double altura;
    private double peso;
    private ModelPessoa pessoa;

    public DTOPaciente(String historico_medico, String grupo_sanguineo, double altura, double peso, ModelPessoa pessoa) {
        this.historico_medico = historico_medico;
        this.grupo_sanguineo = grupo_sanguineo;
        this.altura = altura;
        this.peso = peso;
        this.pessoa = pessoa;
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

    public ModelPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(ModelPessoa pessoa) {
        this.pessoa = pessoa;
    }
}
