package org.acme.Repository.Funcionario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Funcionarios.DTOFuncionario;
import org.acme.Model.DTOs.Pacientes.DTOPaciente;
import org.acme.Model.ModelFuncionario;
import org.acme.Model.ModelPaciente;
import org.acme.Model.ModelPessoa;
import org.acme.Repository.RepositoryPessoa;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepositoryFuncionario {
    @Inject
    DataSource dataSource;

    public void inserirPessoa (DTOFuncionario funcionario) throws SQLException {
        String sql = "insert into T_HCFMUSP_FUNCIONARIO (setor, cargo, st_credencial, id_pessoa) values (?, ?, ?, ?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, funcionario.getSetor());
            ps.setString(2, funcionario.getCargo());
            ps.setString(3, funcionario.getSt_credencial());
            ps.setInt(4, funcionario.getPessoa().getId_pessoa());

            ps.executeUpdate();
        }
    }

    public List<ModelFuncionario> listar() throws SQLException {
        String sql ="Select * from T_HCFMUSP_FUNCIONARIO Order by ID";//saída ordenada
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql) ){
            ResultSet rs = ps.executeQuery();//lista
            List<ModelFuncionario> listaFuncionarios = new ArrayList<>();
            List<ModelPessoa> listaPessoas = new RepositoryPessoa().listar();
            while(rs.next()){
                for (ModelPessoa pessoa : listaPessoas){
                    if (pessoa.getId_pessoa() == rs.getInt(6)){
                        ModelFuncionario modelFuncionario = new ModelFuncionario
                                (
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        pessoa
                                );
                        listaFuncionarios.add(modelFuncionario);
                    }
                }

            }
            return listaFuncionarios;
        }
    }

    public ModelFuncionario recuperarFuncionario (DTOFuncionario DTOFuncionario) throws SQLException {
        String sql = "SELECT * FROM T_HCFMUSP_FUNCIONARIO WHERE id_pessoa = ?";
        ModelFuncionario funcionario = null;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, DTOFuncionario.getPessoa().getId_pessoa());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcionario = new ModelFuncionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), DTOFuncionario.getPessoa());
            }
        }
        return funcionario;
    }
}
