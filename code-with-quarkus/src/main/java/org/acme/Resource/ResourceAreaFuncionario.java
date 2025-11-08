package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTOs.DTOPacienteFull;
import org.acme.Model.DTOs.Pacientes.DTOPacienteDelete;
import org.acme.Service.AreaFuncionario.ServiceEdicaoPaciente;


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
    @Path("/deletar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletar(DTOPacienteDelete dtoPacienteDelete){
        try {
            if (serviceEdicaoPaciente.deletarConta(dtoPacienteDelete.getIdLoginPaciente(), dtoPacienteDelete.getIdPaciente(), dtoPacienteDelete.getIdPessoa())){
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("Erro de Conexão com a Base De Dados").build();
        }
    }

    @GET
    @Path("/recupera-por-id/{id}")
    public Response recuperaPorId(@PathParam("id") int id){
        try{
            DTOPacienteFull pacienteFull = serviceEdicaoPaciente.retornaPorId(id);
            return Response.status(Response.Status.OK).entity(pacienteFull).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("Erro de Conexão com a Base De Dados").build();
        }
    }

    @PUT
    @Path("/atualizar-paciente")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(DTOPacienteFull pacienteFull){
        try{
            serviceEdicaoPaciente.atualizar(pacienteFull);
            return Response.status(Response.Status.OK).entity(pacienteFull).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("Erro de Conexão com a Base De Dados").build();
        }
    }

}
