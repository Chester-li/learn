package rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import rest.model.User;

@Path("userManage")
public class UserService {

    @GET
    @Path("/get")
    @Produces("application/xml")
    public User getUserInXML() {
        return new User();
    }

}