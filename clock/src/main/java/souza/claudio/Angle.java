package souza.claudio;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Claudio Souza
 */
@XmlRootElement
public class Angle {

    private int n_angle;
    private HashMap values = new HashMap();

    public Angle() {
    }

    public int getAngle() {
        return n_angle;
    }
    /**
    * Set Angle Method.
    * Receives the hour and minutes to get the angle from.
    * The hour should be between 0 and 11 and minutes between 0 and 59.
    * Any invalid parameter will return as -1
    * 
    * @param n_hour
    * @param n_minute 
    */
    public void setAngle(int n_hour, int n_minute) {
        if (n_hour < 12 && n_hour >= 0 && n_minute < 60 && n_minute >= 0) {
            int angle;
            int hour_position = (n_hour * 30) + (n_minute / 2);
            int minute_position = (n_minute * 6);

            if (hour_position >= minute_position) {
                angle = hour_position - minute_position;
                n_angle = adjustAngle(angle);
            } else {
                angle = minute_position - hour_position;
                n_angle = adjustAngle(angle);
            }
        } else {
            n_angle = -1;
        }
    }
    /**
     * Adjusts angle to always return the smallest.
     * 
     * @param angle to adjust
     * @return the smallest angle 
     */
    private int adjustAngle(int angle) {
        if (angle > 180) {
            return 360 - angle;
        } else {
            return angle;
        }
    }

    /**
     * @return the values
     */
    public HashMap getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(HashMap values) {
        this.values = values;
    }


}
