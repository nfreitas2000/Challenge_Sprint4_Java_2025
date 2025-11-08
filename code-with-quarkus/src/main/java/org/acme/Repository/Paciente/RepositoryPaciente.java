package org.acme.Repository.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPacienteFull;
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

    public List<DTOPacienteFull> listarPacientesCompletos() throws SQLException {
        String sql = """
            SELECT 
                lp.ID_LOGIN_PACIENTE,
                lp.NM_USUARIO,
                lp.SENHA,
                p.ID_PACIENTE,
                p.HISTORICO_MEDICO,
                p.GRUPO_SANGUINEO,
                p.ALTURA,
                p.PESO,
                pe.ID_PESSOA,
                pe.NM_PESSOA,
                pe.CPF,
                pe.RG,
                pe.DT_NASCIMENTO,
                pe.SX_PESSOA,
                pe.ESTADO_CIVIL,
                pe.ESCOLARIDADE
            FROM T_HCFMUSP_LOGIN_PACIENTE lp
            JOIN T_HCFMUSP_PACIENTE p ON lp.ID_PACIENTE = p.ID_PACIENTE
            JOIN T_HCFMUSP_PESSOA pe ON p.ID_PESSOA = pe.ID_PESSOA
        """;

        List<DTOPacienteFull> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DTOPacienteFull paciente = new DTOPacienteFull(
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
                        rs.getString("ESCOLARIDADE")
                );
                lista.add(paciente);
            }
        }

        return lista;
    }

    public void removerPaciente(int id) throws SQLException {
        String sql = "Delete from T_HCFMUSP_PACIENTE where id_paciente = ?";

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
}