/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.controller;

import co.edu.unicundi.medicoejb.entity.Medico;
import co.edu.unicundi.medicoejb.exception.IntegridadException;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import co.edu.unicundi.medicoejb.interfaz.IMedicoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Julian
 */
@Stateless
@Path("/medicos")
public class MedicoController {
    
    @EJB
    private IMedicoService medicoDao;
    
    /**
     * Método para obtener todos los elementos de la lista
     * @return Response
     */
    @Path("/listar")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response obtenerLista(){
        
        List<Medico> listaMedicos = medicoDao.getListaMedicos();

        return Response.status(Response.Status.FOUND)
                .entity(listaMedicos)
                .build();
        
    }

    /**
     * Método de obtener un elemento de la lista
     * @param id
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     */
    @Path("/listar/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response obtenerPorId(
            @PathParam("id") Integer id) throws ModelNotFoundException{

        Medico estBuscar = medicoDao.buscarMedico(id);

        return Response.status(Response.Status.FOUND)
                .entity(estBuscar)
                .build();

    }

    /**
     * Método para insertar un registro
     * @param medico
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     */
    @Path("/guardar")
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response guardar(
            Medico medico) throws IntegridadException {
        
        System.out.println(medico);
        
        medicoDao.agregarMedico(medico);
        return Response.status(Response.Status.CREATED)
                       .entity(medico)
                       .build();

        
    }

    /**
     * Método que edita un registro 
     * @param medico
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     */
    @Path("/editar")
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editar(
            Medico medico) throws ModelNotFoundException, IntegridadException {

        medicoDao.editarMedico(medico);

        return Response.status(Response.Status.OK)
                       .entity(medico)
                       .build();


    }

    /**
     * Método para eliminar un registro
     * @param id
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     */
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response eliminar(
            @PathParam("id") Integer id) throws ModelNotFoundException {

        medicoDao.eliminarMedico(id);

        return Response.status(Response.Status.OK)
                       .build();

    }
}

