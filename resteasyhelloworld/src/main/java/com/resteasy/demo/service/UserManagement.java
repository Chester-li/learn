package com.resteasy.demo.service;

import com.resteasy.demo.model.User;
import com.resteasy.demo.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by chaoshuai.li on 2017/11/24.
 */
@Path("/user")
public class UserManagement {
    @GET
    @Path("/")
    public Response info()
    {
        String result = "<h1>RESTful Demo Application</h1>In real world application, a collection of users will be returned !!";
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getAllUsers")
    public Response getAllUsers(){
        User user1 = new User(1, "charles", "li","allusers");
        User user2 = new User(2, "charles", "li","allusers");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        return Response.status(200).entity(JsonUtils.toJson(users)).build();
    }
}
