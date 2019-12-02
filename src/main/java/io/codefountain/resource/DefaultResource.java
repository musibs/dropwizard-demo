package io.codefountain.resource;

import com.codahale.metrics.annotation.Timed;
import io.codefountain.model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class DefaultResource {

    private final String defaultFirstName;
    private final String defaultLastName;

    public DefaultResource(String defaultFirstName, String defaultLastName){
        this.defaultFirstName = defaultFirstName;
        this.defaultLastName = defaultLastName;
    }

    @GET
    @Timed
    public Person getPerson(@QueryParam("firstName") Optional<String> firstName,
                            @QueryParam("lastName") Optional<String> lastName){
        return new Person(firstName.orElse(defaultFirstName), lastName.orElse(defaultLastName));
    }
}
