/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.filter;

import co.edu.unicundi.medicoejb.exception.EmptyModelException;
import co.edu.unicundi.medicoweb.pojo.ErrorDto;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Julian
 */

@Provider
public class EmptyModelExceptionFilter implements ExceptionMapper<EmptyModelException> {

    @Context
    private HttpServletRequest request;
    
    
    @Override
    public Response toResponse(EmptyModelException e) {
        
        ErrorDto error = new ErrorDto(e.getMessage(), request.getRequestURI());

        return Response.status(Response.Status.CONFLICT)
                .entity(error)
                .build();
    }
}

