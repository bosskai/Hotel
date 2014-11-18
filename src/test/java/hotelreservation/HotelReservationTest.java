package hotelreservation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by bosskai on 2014/11/13.
 */
public class HotelReservationTest {
    protected HotelReservation hotelReservation = new HotelReservation();

    @Test
    public void should_answer_lakewood() throws Exception {
        String dateString = "Regular:16Mar2009(mon),17Mar2009(tues),18Mar2009(wed)";
        String expect = "LakeWood";
        assertTrue(expect.equalsIgnoreCase(hotelReservation.bestChoice(dateString)));
    }

    @Test
    public void should_answer_bridgeWood() throws Exception {
        String dateString = "Regular:20Mar2009(fri),21Mar2009(sat),22Mar2009(sun)";
        String expect = "BridgeWood";
        assertTrue(expect.equalsIgnoreCase(hotelReservation.bestChoice(dateString)));
    }

    @Test
    public void should_answer_ridgeWood() throws Exception {
        String dateString = "Rewards:26Mar2009(thur),27Mar2009(fri),28Mar2009(sat)";
        String expect = "RidgeWood";
        assertTrue(expect.equalsIgnoreCase(hotelReservation.bestChoice(dateString)));
    }

}
