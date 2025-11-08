package org.acme.Repository.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPacienteFull;
import org.acme.Model.DTOs.Pacientes.DTOContaPaciente;
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

    public List<DTOContaPaciente> listarLogins() throws SQLException {
        String sql ="Select * from T_HCFMUSP_LOGIN_PACIENTE";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){
            ResultSet rs = ps.executeQuery();
            List<DTOContaPaciente> listaLoginPacientes = new ArrayList<>();
            while(rs.next()){
                listaLoginPacientes.add(new DTOContaPaciente(rs.getString(2), rs.getString(3)));
            }
            return listaLoginPacientes;
        }
    }

    public void removerContaPaciente(int id) throws SQLException {
        String sql = "Delete from T_HCFMUSP_LOGIN_PACIENTE where ID_LOGIN_PACIENTE = ?";

        try (Connection con = dataSource.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setInt(1, id);
                int funcionou = st.executeUpdate();
                if (funcionou > 0) {
                    con.commit();
                } else {
                    con.rollback();
                }
            }
        }
    }

    public DTOPacienteFull recuperarPorID(int id) throws SQLException {
        DTOPacienteFull paciente = null;
        String sql = "SELECT lp.ID_LOGIN_PACIENTE, lp.NM_USUARIO, lp.SENHA, p.ID_PACIENTE, p.HISTORICO_MEDICO, p.GRUPO_SANGUINEO, p.ALTURA, p.PESO, pe.ID_PESSOA, pe.NM_PESSOA, pe.CPF, pe.RG, pe.DT_NASCIMENTO, pe.SX_PESSOA, pe.ESTADO_CIVIL, pe.ESCOLARIDADE FROM T_HCFMUSP_LOGIN_PACIENTE lp JOIN T_HCFMUSP_PACIENTE p ON lp.ID_PACIENTE = p.ID_PACIENTE JOIN T_HCFMUSP_PESSOA pe ON p.ID_PESSOA = pe.ID_PESSOA WHERE id_login_paciente = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                paciente = new DTOPacienteFull(
                rs.getInt("ID_LOGIN_PACIENTE"),
                rs.getString("NM_USUARIO"),
                rs.getString("SENHA"),
                rs.getInt("ID_PACIENTE"),
                rs.getString("HISTORICO_MEDICO"),
                rs.getString("GRUPO_SANGUINEO"),
                rs.getDouble("ALTURA"),
                rs.getDouble("PESO"),
                rs.getInt("ID_PESSOA"),
                rs.getString("NM_PESSOA"),
                rs.getString("CPF"),
                rs.getString("RG"),
                rs.getString("DT_NASCIMENTO"),
                rs.getString("SX_PESSOA"),
                rs.getString("ESTADO_CIVIL"),
                rs.getString("ESCOLARIDADE"));
            }
        }
        return paciente;
    }

    public void atualizar(DTOPacienteFull paciente) throws SQLException {
        String sqlPessoa = """
            UPDATE T_HCFMUSP_PESSOA
            SET NM_PESSOA = ?, CPF = ?, RG = ?, DT_NASCIMENTO = ?, 
            SX_PESSOA = ?, ESTADO_CIVIL = ?, ESCOLARIDADE = ?
            WHERE ID_PESSOA = ?
        """;

        String sqlPaciente = """
            UPDATE T_HCFMUSP_PACIENTE
            SET HISTORICO_MEDICO = ?, GRUPO_SANGUINEO = ?, ALTURA = ?, PESO = ?
            WHERE ID_PACIENTE = ?
        """;

        String sqlLogin = """
            UPDATE T_HCFMUSP_LOGIN_PACIENTE
            SET NM_USUARIO = ?, SENHA = ?
            WHERE ID_LOGIN_PACIENTE = ?
        """;

        try (Connection con = dataSource.getConnection()) {
            con.setAutoCommit(false);

            try (
                    PreparedStatement stmtPessoa = con.prepareStatement(sqlPessoa);
                    PreparedStatement stmtPaciente = con.prepareStatement(sqlPaciente);
                    PreparedStatement stmtLogin = con.prepareStatement(sqlLogin)
            ) {
                // Atualiza PESSOA
                stmtPessoa.setString(1, paciente.getNmPessoa());
                stmtPessoa.setString(2, paciente.getCpf());
                stmtPessoa.setString(3, paciente.getRg());
                stmtPessoa.setDate(4, java.sql.Date.valueOf(paciente.getDtNascimento()));
                stmtPessoa.setString(5, paciente.getSxPessoa());
                stmtPessoa.setString(6, paciente.getEstadoCivil());
                stmtPessoa.setString(7, paciente.getEscolaridade());
                stmtPessoa.setInt(8, paciente.getIdPessoa());
                stmtPessoa.executeUpdate();

                // Atualiza PACIENTE
                stmtPaciente.setString(1, paciente.getHistoricoMedico());
                stmtPaciente.setString(2, paciente.getGrupoSanguineo());
                stmtPaciente.setDouble(3, paciente.getAltura());
                stmtPaciente.setDouble(4, paciente.getPeso());
                stmtPaciente.setInt(5, paciente.getIdPaciente());
                stmtPaciente.executeUpdate();

                // Atualiza LOGIN
                stmtLogin.setString(1, paciente.getNmUsuario());
                stmtLogin.setString(2, paciente.getSenha());
                stmtLogin.setInt(3, paciente.getIdLoginPaciente());
                stmtLogin.executeUpdate();

                con.commit();

            } catch (SQLException e) {
                con.rollback();
            }
        }
    }
}
