
package souza.claudio;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Claudio Souza
 */
public class AngleTest {

    Angle angle;

    public AngleTest() {
    }

    @Before
    public void setUp() {

        angle = new Angle();

    }

    @After
    public void tearDown() {

        angle = null;

    }

    /**
     * Test of setAngle method, Two Valid Parameters
     */
    @Test
    public void testSetAngle() {
        angle.setAngle(6, 0);
        Assert.assertEquals(180, angle.getAngle());
    }
    
    /**
     * Test of setAngle method, only second parameter valid
     */
    @Test
    public void testSetAngleFirstInvalid() {
        angle.setAngle(16, 0);
        Assert.assertEquals(-1, angle.getAngle());
    }

    /**
     * Test of setAngle method, only first parameter valid
     */
    @Test
    public void testSetAngleSecondInvalid() {
        angle.setAngle(7, -32);
        Assert.assertEquals(-1, angle.getAngle());
    }
    
    /**
     * Test of setAngle method, two invalid parameters
     */
    @Test
    public void testSetAngleTwoInvalid() {
        angle.setAngle(-3, 65);
        Assert.assertEquals(-1, angle.getAngle());
    }
    /**
     * Get values from HashMap
     */
    @Test
    public void testGetCalculated(){
        String key = "9:00";
        angle.setAngle(9, 0);
        angle.getValues().putIfAbsent(key, angle.getAngle());
        
        Assert.assertEquals(90, angle.getValues().get(key));
    }
    
  }
