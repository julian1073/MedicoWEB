/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.filter;

import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import co.edu.unicundi.medicoweb.pojo.ErrorDto;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Julian
 * @version 1.0.0
 * @since 18/03/2021
 */
@Provider
public class ModelNotFoundExceptionFilter implements ExceptionMapper<ModelNotFoundException> {

    @Context
    private HttpServletRequest request;
    
    
    @Override
    public Response toResponse(ModelNotFoundException exception) {
        
        ErrorDto error = new ErrorDto(exception.getMessage(), request.getRequestURI());
        
            
            return Response.status(Response.Status.NOT_FOUND)
                           .entity(error)
                           .build();
    }
}
