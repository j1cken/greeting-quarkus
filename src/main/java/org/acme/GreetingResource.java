package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(defaultValue = "world")
    String name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Say hello", description = "Welcome everybody here in the room!")
    public String hello() {
        return "Hello " + name;
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Say hello", description = "Welcome everybody here in the room!")
    @Parameter(description = "1st param", required = true, example = "Your name")
    @Counted(name = "mycounter")
    public String hola(@PathParam("name") String name) {
        return "Hello " + name;
    }

}
