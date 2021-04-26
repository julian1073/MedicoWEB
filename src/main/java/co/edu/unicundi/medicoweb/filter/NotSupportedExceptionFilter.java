/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.filter;

import co.edu.unicundi.medicoweb.pojo.ErrorDto;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotSupportedException;
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
public class NotSupportedExceptionFilter implements ExceptionMapper<NotSupportedException> {
    
    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(NotSupportedException exception) {
        ErrorDto error = new ErrorDto("Not Supported Exception - El formato de los datos no es correcto", request.getRequestURI());
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE)
                        .entity(error)
                        .build();
    }
}
