/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.filter;
import co.edu.unicundi.medicoweb.pojo.ErrorDto;
import javax.json.stream.JsonParsingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Julian Julián Vásquez, Daniel Perez
 * @version 1.0.0
 * @since 11/03/2021
 */
@Provider
public class JsonParsingExceptionFilter implements ExceptionMapper<JsonParsingException>{

    @Context
    private HttpServletRequest request;
    
    @Override
    public Response toResponse(JsonParsingException e) {
        ErrorDto error = new ErrorDto("El Json está mal estructurado", request.getRequestURI());
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(error)
                        .build();
    }
}
