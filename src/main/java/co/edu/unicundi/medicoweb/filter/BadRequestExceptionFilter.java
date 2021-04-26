/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.filter;

import co.edu.unicundi.medicoweb.pojo.ErrorDto;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;
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
public class BadRequestExceptionFilter implements ExceptionMapper<BadRequestException> {
    
    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(BadRequestException exception) {
        ErrorDto error = new ErrorDto("Bad Request Exception", request.getRequestURI());
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(error)
                        .build();
    }
}

