package br.com.debpay.controllers;

import br.com.debpay.Container;
import com.google.gson.Gson;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserController {

  @POST
  @Path("/login")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUser(String JSONInput) {
    // TODO we should validate the parameters
    var user = new Gson().fromJson(JSONInput, JSONInput.User.class);
    var service = Container.getUserService();
    var userDto = service.login(user.login, user.password);

    if (userDto != null) {
      return Response.status(Response.Status.OK).entity(userDto).build();
    }

    return Response.status(Response.Status.UNAUTHORIZED).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response postUser(String JSONInput) {
    // TODO we should validate the parameters
    var user = new Gson().fromJson(JSONInput, JSONInput.User.class);
    var service = Container.getUserService();
    var userDTO = service.createUser(user.login, user.password, user.name);

    return Response.status(Response.Status.OK).entity(userDTO).build();
  }
}
