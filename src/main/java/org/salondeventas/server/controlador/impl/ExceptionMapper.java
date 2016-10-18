package org.salondeventas.server.controlador.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
    	System.out.println("****************Exception: " + exception.getMessage());
        exception.printStackTrace();
        return Response.status(500).build();
    }
}
