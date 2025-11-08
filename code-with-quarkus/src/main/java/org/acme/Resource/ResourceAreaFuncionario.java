package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTOs.DTOPacienteFull;
import org.acme.Model.DTOs.Funcionarios.DTOContaFuncionario;
import org.acme.Model.DTOs.Pacientes.DTOContaPaciente;
import org.acme.Model.ModelPaciente;
import org.acme.Service.AreaFuncionario.ServiceEdicaoPaciente;
import org.acme.Service.Login.ServiceLoginFuncionario;
import org.acme.Service.Login.ServiceLoginPaciente;

import java.sql.SQLException;
import java.util.List;

@Path("/funcionario")
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceAreaFuncionario {
    @Inject
    ServiceEdicaoPaciente serviceEdicaoPaciente;

    @GET
    @Path("/lista-pacientes")
    public Response listar(){
        try{
            List<DTOPacienteFull> listaPaciente= serviceEdicaoPaciente.listar();
            return Response.status(Response.Status.OK).entity(listaPaciente).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("Erro de Conexão com a Base De Dados").build();
        }
    }

    @DELETE
    @Path("deletar/{id}")
    public Response deletar(@PathParam("id") int idPaciente){


    }

}
