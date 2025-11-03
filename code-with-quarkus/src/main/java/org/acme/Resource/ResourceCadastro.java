package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTOs.Pacientes.DTOPacienteCompleto;
import org.acme.Service.ServicePacienteCompleto;

import java.sql.SQLException;
import java.util.List;

@Path("/cadastro")
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceCadastro {
    @Inject
    ServicePacienteCompleto servicePacienteCompleto;

    @POST
    @Path("/criarContaPaciente")
    public Response criar (DTOPacienteCompleto dadosCompleto){
        try{
            servicePacienteCompleto.criar(dadosCompleto);
            return Response.status(Response.Status.CREATED)
                    .entity("Criado com Sucesso").build();

        } catch (SQLException e) {//erro de conexão com a base
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados").build();
        }
        catch (IllegalArgumentException e) { //erro de dados na validação
            return Response.status(422).entity(e.getMessage()).build();
        }
    }
}
