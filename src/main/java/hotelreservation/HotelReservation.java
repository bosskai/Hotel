package main.java.hotelreservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bosskai on 2014/11/13.
 */
public class HotelReservation {
    public String bestChoice(List<Hotel> hotelList, String date, final int customerType) throws Exception {
        
        List<Date> listDate = parseDate(date);

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

    private List<Date> parseDate(String date) {
        List<Date> listDate = new ArrayList<Date>();
        return listDate;
    }

}
