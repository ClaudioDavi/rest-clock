package souza.claudio;

import souza.claudio.Main;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AngleResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test return message from method AngleMinute0 with valid parameter Sample
     * taken from Email
     */
    @Test
    public void testAngleMinute0() {
        String responseMsg = target.path("/3").request().get(String.class);
        assertEquals("{\"angle\":90}", responseMsg);
    }

    /**
     * Test return message from method Angle with valid parameter Sample taken
     * from Email
     */
    @Test
    public void testAngle() {
        String responseMsg = target.path("/9").request().get(String.class);
        assertEquals("{\"angle\":90}", responseMsg);

    }

    /**
     * Test return message from Angle with invalid parameter
     */
    @Test
    public void testAngleInvalid() {
        String responseMsg = target.path("/-1").request().get(String.class);
        assertEquals("{\"angle\":-1}", responseMsg);
    }

    /**
     * Test return message from method Angle with valid parameter /6/0 Sample
     * taken from Email
     */
    @Test
    public void testAngle60() {
        String responseMsg = target.path("/6/0").request().get(String.class);
        assertEquals("{\"angle\":180}", responseMsg);
    }

    /**
     * Test return message from method Angle with invalid parameter /12/0
     */
    @Test
    public void testAngleInvalidFirst() {
        String responseMsg = target.path("/12/0").request().get(String.class);
        assertEquals("{\"angle\":-1}", responseMsg);
    }

    /**
     * Test return message from method Angle with invalid parameters /11/62
     */
    @Test
    public void testAngleInvalidSecond() {
        String responseMsg = target.path("/11/62").request().get(String.class);
        assertEquals("{\"angle\":-1}", responseMsg);
    }

    /**
     * Test return message from method Angle with invalid parameter /-3/60
     */
    @Test
    public void testAngleInvalidBoth() {
        String responseMsg = target.path("/-3/60").request().get(String.class);
        assertEquals("{\"angle\":-1}", responseMsg);
    }
}
