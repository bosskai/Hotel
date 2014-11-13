package main.java.hotelreservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bosskai on 2014/11/13.
 */
public class HotelReservation {
    public String bestChoice(List<Hotel> hotelList, List<String> date,int customerType) throws Exception {
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
            @Override
            public abstract int  compare(Hotel arg0, Hotel arg1) {
                int i = arg0.calculatePrice(date, customerType).compareTo(arg1.calculatePrice(date, customerType));
                return 0;
            }

        });
          return "";
    }
}
