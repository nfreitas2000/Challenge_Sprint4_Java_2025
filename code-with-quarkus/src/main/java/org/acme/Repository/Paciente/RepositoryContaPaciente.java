package org.acme.Repository.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Pacientes.DTOLoginPaciente;
import org.acme.Model.ModelLoginPaciente;
import org.acme.Model.ModelPaciente;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepositoryContaPaciente {
    @Inject
    DataSource dataSource;

    public void inserirPessoa (DTOLoginPaciente loginPaciente) throws SQLException {
        String sql = "insert into T_HCFMUSP_LOGIN_PACIENTE(nm_usuario, senha, id_paciente) values (?, ?, ?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, loginPaciente.getNm_usuario());
            ps.setString(2, loginPaciente.getSenha());
            ps.setInt(3, loginPaciente.getPaciente().getId_paciente());

            ps.executeUpdate();
        }
    }

    public List<ModelLoginPaciente> listar() throws SQLException {
        String sql ="Select * from T_HCFMUSP_LOGIN_PACIENTE Order by ID";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql) ){
            ResultSet rs = ps.executeQuery();
            List<ModelLoginPaciente> listaLoginPacientes = new ArrayList<>();
            List<ModelPaciente> listaPacientes = new RepositoryPaciente().listar();
            while(rs.next()){
                for (ModelPaciente paciente : listaPacientes){
                    if (paciente.getId_paciente() == rs.getInt(4)){
                        ModelLoginPaciente modelLoginPaciente = new ModelLoginPaciente
                                (
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        paciente
                                );
                        listaLoginPacientes.add(modelLoginPaciente);
                    }
                }

            }
            return listaLoginPacientes;
        }
    }
}
