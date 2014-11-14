package hotelreservation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by bosskai on 2014/11/13.
 */
public class HotelReservationTest {

    protected List<Hotel> hotelList;
    protected HotelReservation hotelReservation = new HotelReservation();

    @Before
    public void setUp() {
        Hotel lakeWood = new Hotel("LakeWood", 3, 110, 80, 90, 80);
        Hotel bridgeWood = new Hotel("BridgeWood", 4, 160, 110, 60, 50);
        Hotel ridgeWood = new Hotel("RidgeWood", 5, 220, 100, 150, 40);
        hotelList = new ArrayList<Hotel>();
        hotelList.add(lakeWood);
        hotelList.add(bridgeWood);
        hotelList.add(ridgeWood);
    }

    @Test
    public void should_answer_lakewood() throws Exception {
        String dateString = "2009-03-16,2009-03-17,2009-03-18";
        String expect = "LakeWood";
        assertTrue(expect.equalsIgnoreCase(hotelReservation.bestChoice(hotelList, dateString, "regular")));
    }

    @Test
    public void should_answer_bridgewood() throws Exception {
        String dateString = "2009-03-20,2009-03-21,2009-03-22";
        String expect = "BridgeWood";
        assertTrue(expect.equalsIgnoreCase(hotelReservation.bestChoice(hotelList, dateString, "regular")));
    }

    @Test
    public void should_answer_ridgewood() throws Exception {
        String dateString = "2009-03-26,2009-03-27,2009-03-28";
        String expect = "RidgeWood";
        assertTrue(expect.equalsIgnoreCase(hotelReservation.bestChoice(hotelList, dateString, "rewards")));
    }

    @Test
    public void total_price_should_be_regular_when_date_is_out_of_valid() throws Exception {
        String dateString = "2009-03-01";
        Hotel lakeWood = new Hotel("LakeWood", 3, 110, 80, 90, 80, "03-01", "03-20");
        Double expect = Double.valueOf(110);
        assertTrue(expect == lakeWood.calculatePrice(hotelReservation.parseDate(dateString), "rewards"));
    }

//    @Test
//    public void special_date_should_answer_ridgewood() throws Exception {
//        Hotel lakeWood = new Hotel("LakeWood", 3, 110, 80, 90, 80, "2009-03-26");
//        Hotel bridgeWood = new Hotel("BridgeWood", 4, 160, 110, 60, 50, "2009-03-26");
//        Hotel ridgeWood = new Hotel("RidgeWood", 5, 220, 100, 150, 40, "2009-03-26");
//        hotelList = new ArrayList<Hotel>();
//        hotelList.add(lakeWood);
//        hotelList.add(bridgeWood);
//        hotelList.add(ridgeWood);
//
//        String dateString = "2009-03-26,2009-03-27,2009-03-28";
//        String expect = "LakeWood";
//        assertTrue(expect.equalsIgnoreCase(hotelReservation.bestChoice(hotelList, dateString, "rewards")));
//    }

}
