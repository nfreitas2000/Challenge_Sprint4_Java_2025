package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTOs.Funcionarios.DTOContaFuncionario;
import org.acme.Model.DTOs.Pacientes.DTOContaPaciente;
import org.acme.Service.Cadastro.Funcionario.ServiceLoginFuncionario;
import org.acme.Service.Cadastro.Paciente.ServiceLoginPaciente;

import java.sql.SQLException;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceLogin {
    @Inject
    ServiceLoginPaciente serviceLoginPaciente;
    @Inject
    ServiceLoginFuncionario serviceLoginFuncionario;

    @POST
    @Path("/funcionario")
    public Response loginFuncionario (DTOContaFuncionario contaFuncionario){
        try{
            if (serviceLoginFuncionario.validacaoLoginFuncionario(contaFuncionario)) {
                return Response.status(Response.Status.OK).entity("Logado com sucesso").build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).entity("Conta não cadastrada").build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }
    }

    @POST
    @Path("/paciente")
    public Response loginPaciente (DTOContaPaciente contaPaciente){
        try{
            boolean validacao = serviceLoginPaciente.validacaoLoginPaciente(contaPaciente);
            if (validacao){
                return Response.status(Response.Status.OK).entity("Logado com sucesso").build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).entity("Conta não cadastrada").build();
            }
        } catch (SQLException e) {//erro de conexão com a base
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }
    }
}
