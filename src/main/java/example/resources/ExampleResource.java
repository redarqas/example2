package example.resources;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/mailgun")
public class ExampleResource {

    @GET
    @Path("info")
    @Produces("application/text")
    public String info() {
        return "Mailgun resource";
    }

    @POST
    @Path("/callback")
    @Consumes(MediaType.WILDCARD)
    public String callback(FormDataMultiPart multiPart) {

        Map<String, List<FormDataBodyPart>> parts = multiPart.getFields();

        parts.forEach((k, vs) -> {
            System.out.println("Name : " + k);
            vs.forEach(v -> System.out.println(" ------------------------ " + v.getMediaType().toString()));
        });
        return "OK";
    }

}
