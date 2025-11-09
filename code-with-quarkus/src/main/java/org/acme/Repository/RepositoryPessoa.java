package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.DTOPessoa;
import org.acme.Model.ModelPessoa;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class RepositoryPessoa {
    @Inject
    DataSource dataSource;

    public void inserirPessoa (DTOPessoa pessoa) throws SQLException{
        String sql = "insert into T_HCFMUSP_PESSOA(nm_pessoa, cpf, rg, dt_nascimento, sx_pessoa, estado_civil, escolaridade) values (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, pessoa.getNm_pessoa());
            ps.setString(2, pessoa.getCpf());
            ps.setString(3, pessoa.getRg());
            ps.setString(4, pessoa.getDt_nascimento());
            ps.setString(5, pessoa.getSx_pessoa());
            ps.setString(6, pessoa.getEstado_civil());
            ps.setString(7, pessoa.getEscolaridade());

            ps.executeUpdate();
        }
    }

    public List<ModelPessoa> listar() throws SQLException {
        String sql ="Select * from T_HCFMUSP_PESSOA Order by ID";//saída ordenada
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql) ){
            ResultSet rs = ps.executeQuery();//lista
            List<ModelPessoa> listaPessoas = new ArrayList<>();
            while(rs.next()){
                //recuperando cliente pelo construtor
                ModelPessoa modelPessoa = new ModelPessoa
                        (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                        );
                //Adicionando cliente na lista
                listaPessoas.add(modelPessoa);
            }
            return listaPessoas;
        }
    }
    public ModelPessoa recuperarPessoa (String cpf) throws SQLException {
        String sql = "SELECT * FROM T_HCFMUSP_PESSOA WHERE cpf = ?";
        ModelPessoa pessoa = null;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pessoa = new ModelPessoa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        }
        return pessoa;
    }

    public void removerPessoa(int id) throws SQLException {
        String sql = "Delete from T_HCFMUSP_PESSOA where id_pessoa = ?";

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