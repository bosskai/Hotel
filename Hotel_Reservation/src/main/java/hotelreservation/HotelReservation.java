package main.java.hotelreservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bosskai on 2014/11/13.
 */
public class HotelReservation {
    public String bestChoice(List<Hotel> hotelList, final List<String> date, final int customerType) throws Exception {
        double lakeWoodPrice = 0;
        double bridgeWoodPrice = 0;
        double ridgeWoodPrice = 0;
        List list = new ArrayList();
        for (Hotel hotel : hotelList) {
            hotel.getHotelName();
            hotel.getRating();
            hotel.calculatePrice(date, customerType);

        }
        Collections.sort(hotelList,new Comparator(){
//            @Override
            public int compare(Hotel o1, Hotel o2) throws Exception {
                int i = o1.calculatePrice(date, customerType).compareTo(o2.calculatePrice(date, customerType));
//                arg0.getRating().compareTo(arg0.getRating());
                return 0;
            }
        });

          return "";
    }
}
