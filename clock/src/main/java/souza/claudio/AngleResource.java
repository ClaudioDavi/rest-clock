package souza.claudio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

/**
 * @author Claudio Souza
 */
@Path("/")
public class AngleResource {

    Angle ang = new Angle();

    @GET
    @Path("{hour}/{minute}")
    @Produces(MediaType.APPLICATION_JSON)
    public String Angle(@PathParam("hour") int hour,
            @PathParam("minute") int minute) {

        String key = hour + ":" + minute;

        ang.setAngle(hour, minute);
        ang.getValues().putIfAbsent(key, ang.getAngle());

        return "{\"angle\":" + ang.getValues().get(key) + "}";
    }

    @GET
    @Path("{hour}")
    @Produces(MediaType.APPLICATION_JSON)
    public String AngleMinute0(@PathParam("hour") int hour) {

        String key = hour + ":" + 00;

        ang.setAngle(hour, 00);
        ang.getValues().putIfAbsent(key, ang.getAngle());

        return "{\"angle\":" + ang.getValues().get(key) + "}";
    }
}
