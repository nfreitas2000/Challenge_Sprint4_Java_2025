package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOPaciente;
import org.acme.Model.ModelPaciente;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class RepositoryPaciente {
    @Inject
    DataSource dataSource;

    public void inserirPessoa (DTOPaciente paciente) throws SQLException{
        String sql = "insert into T_HCFMUSP_PACIENTE (historico_medico, grupo_sanguineo, altura, peso, id_pessoa) values (?, ?, ?, ?, ?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, paciente.getHistorico_medico());
            ps.setString(2, paciente.getGrupo_sanguineo());
            ps.setDouble(3, paciente.getAltura());
            ps.setDouble(4, paciente.getPeso());
            ps.setInt(5, paciente.getId_pessoa());

            ps.executeUpdate();
        }
    }

    public List<ModelPaciente> listar() throws SQLException {
        String sql ="Select * from T_HCFMUSP_PACIENTE Order by ID";//saída ordenada
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql) ){
            ResultSet rs = ps.executeQuery();//lista
            List<ModelPaciente> listaPacientes = new ArrayList<>();
            while(rs.next()){
                ModelPaciente modelPaciente = new ModelPaciente
                        (
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDouble(4),
                                rs.getDouble(5),
                                rs.getInt(6)
                        );
                listaPacientes.add(modelPaciente);
            }
            return listaPacientes;
        }
    }
}