package org.acme.Repository.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOPaciente;
import org.acme.Model.ModelPaciente;
import org.acme.Model.ModelPessoa;
import org.acme.Repository.RepositoryPessoa;

import javax.sql.DataSource;

import java.sql.*;
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
            ps.setInt(5, paciente.getPessoa().getId_pessoa());

            ps.executeUpdate();
        }
    }

    public List<ModelPaciente> listar() throws SQLException {
        String sql = "Select * from T_HCFMUSP_PACIENTE";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){
            ResultSet rs = ps.executeQuery();
            List<ModelPaciente> listaPacientes = new ArrayList<>();
            List<ModelPessoa> listaPessoas = new RepositoryPessoa().listar();
            while(rs.next()){
                for (ModelPessoa pessoa : listaPessoas){
                    if (pessoa.getId_pessoa() == rs.getInt(6)){
                        ModelPaciente modelPaciente = new ModelPaciente
                                (
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getDouble(4),
                                        rs.getDouble(5),
                                        pessoa
                                );
                        listaPacientes.add(modelPaciente);
                    }
                }

            }
            return listaPacientes;
        }
    }

    public ModelPaciente recuperarPaciente (DTOPaciente DTOpaciente) throws SQLException {
        String sql = "SELECT * FROM T_HCFMUSP_PACIENTE WHERE id_pessoa = ?";
        ModelPaciente paciente = null;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, DTOpaciente.getPessoa().getId_pessoa());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new ModelPaciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), DTOpaciente.getPessoa());
            }
        }
        return paciente;
    }
}