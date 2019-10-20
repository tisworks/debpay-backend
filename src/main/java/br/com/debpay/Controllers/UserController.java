package br.com.debpay.Controllers;

import br.com.debpay.Container;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserController {

    @GET
    @Path("{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("login") String login) {
        var service = Container.getUserService();
        var user = service.getUser(login);
        return Response
                .status(Response.Status.OK)
                .entity(user)
                .build();
    }
}
