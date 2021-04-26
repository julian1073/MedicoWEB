/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.controller;

import co.edu.unicundi.medicoejb.entity.DetalleConsulta;
import co.edu.unicundi.medicoejb.exception.EmptyModelException;
import co.edu.unicundi.medicoejb.exception.IntegridadException;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import co.edu.unicundi.medicoejb.interfaz.IDetalleConsultaService;
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
@Path("/detalleConsultas")
public class DetalleConsultaController {
    
    @EJB 
    private IDetalleConsultaService detalleDao;
    
    /**
     * Método para obtener todos los elementos de la lista
     * @return Response
     */
    @Path("/listar")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response obtenerLista(){

        List<DetalleConsulta> listaDetalleConsultas = detalleDao.getListaDetalleConsultas();

        return Response.status(Response.Status.FOUND)
                .entity(listaDetalleConsultas)
                .build();
        
    }

    /**
     * Método de obtener un elemento de la lista
     * @param id
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    @Path("/listar/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response obtenerPorId(
            @PathParam("id") Integer id) throws ModelNotFoundException, EmptyModelException{

        DetalleConsulta estBuscar = detalleDao.buscarDetalleConsulta(id);

        return Response.status(Response.Status.FOUND)
                .entity(estBuscar)
                .build();

    }

    /**
     * Método para insertar un registro
     * @param detalleConsulta
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    @Path("/guardar")
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response guardar(
            DetalleConsulta detalleConsulta) throws IntegridadException, EmptyModelException {
        
        detalleDao.agregarDetalleConsulta(detalleConsulta);
        return Response.status(Response.Status.CREATED)
                       .entity(detalleConsulta)
                       .build();

        
    }

    /**
     * Método que edita un registro 
     * @param detalleConsulta
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    @Path("/editar")
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editar(
            DetalleConsulta detalleConsulta) throws ModelNotFoundException, IntegridadException, EmptyModelException {

        detalleDao.editarDetalleConsulta(detalleConsulta);

        return Response.status(Response.Status.OK)
                       .entity(detalleConsulta)
                       .build();


    }

    /**
     * Método para eliminar un registro
     * @param id
     * @return Response
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response eliminar(
            @PathParam("id") Integer id) throws ModelNotFoundException, EmptyModelException {

        detalleDao.eliminarDetalleConsulta(id);

        return Response.status(Response.Status.OK)
                       .build();

    }
}


