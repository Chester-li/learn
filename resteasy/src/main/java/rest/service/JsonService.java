package rest.service;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import rest.model.Movie;
import rest.model.Product;

@Path("/json/product")
public class JSONService {

    //当有两path的value一样的时候使用的是第一个path
    @GET
    @Path("/get")
    @Produces("application/json")
    public Product getProductInJSON() {

        Product product = new Product();
        product.setName("iPad 3");
        product.setId(999);

        return product;

    }

    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createProductInJSON(Product product) {
        String result = "Product created : " + product;
        return Response.status(201).entity(result).build();
    }

    @BadgerFish
    @GET
    @Path("/movie/get")
    @Produces("application/json")
    public Movie getMovieInJSON() {
        Movie movie = new Movie();
        movie.setName("Transformers: Dark of the Moon");
        movie.setDirector("Michael Bay");
        movie.setYear(2011);
        return movie;
    }

}