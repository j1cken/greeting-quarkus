package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Say hello", description = "Welcome everybody here in the room!")
    public String hello() {
        return "Hello there!";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Say hello", description = "Welcome everybody here in the room!")
    @Parameter(
        description = "1st param",
        required = true,
        example = "Your name"
    )
    @Counted(name = "mycounter")
    public String hola(@PathParam("name") String name) {
        return "Hello " + name;
    }

}