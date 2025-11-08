package org.acme.Repository.Funcionario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTOs.Funcionarios.DTOContaFuncionario;
import org.acme.Model.DTOs.Funcionarios.DTOLoginFuncionario;
import org.acme.Model.DTOs.Pacientes.DTOContaPaciente;
import org.acme.Model.ModelFuncionario;
import org.acme.Model.ModelLoginFuncionario;
import org.acme.Model.ModelLoginPaciente;
import org.acme.Model.ModelPaciente;
import org.acme.Repository.Paciente.RepositoryPaciente;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepositoryContaFuncionario {
    @Inject
    DataSource dataSource;

    public void inserirPessoa (DTOLoginFuncionario loginFuncionario) throws SQLException {
        String sql = "insert into T_AX_LOGIN_DASHTECH(user_dashboard, password_dashtech, id_funcionario) values (?, ?, ?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, loginFuncionario.getNm_usuario());
            ps.setString(2, loginFuncionario.getSenha());
            ps.setInt(3, loginFuncionario.getFuncionario().getId_funcionario());

            ps.executeUpdate();
        }
    }

    public List<ModelLoginFuncionario> listar() throws SQLException {
        String sql ="Select * from T_AX_LOGIN_DASHTECH Order by ID";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql) ){
            ResultSet rs = ps.executeQuery();
            List<ModelLoginFuncionario> listaLoginFuncionarios = new ArrayList<>();
            List<ModelFuncionario> listaFuncionarios = new RepositoryFuncionario().listar();
            while(rs.next()){
                for (ModelFuncionario funcionario : listaFuncionarios){
                    if (funcionario.getId_funcionario() == rs.getInt(4)){
                        ModelLoginFuncionario modelLoginFuncionario = new ModelLoginFuncionario
                                (
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        funcionario
                                );
                        listaLoginFuncionarios.add(modelLoginFuncionario);
                    }
                }

            }
            return listaLoginFuncionarios;
        }
    }

    public List<DTOContaFuncionario> listarLogins() throws SQLException {
        String sql ="Select * from T_AX_LOGIN_DASHTECH";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){
            ResultSet rs = ps.executeQuery();
            List<DTOContaFuncionario> listaLoginFuncionarios = new ArrayList<>();
            while(rs.next()){
                listaLoginFuncionarios.add(new DTOContaFuncionario(rs.getString(2), rs.getString(3)));
            }
            return listaLoginFuncionarios;
        }
    }
}
