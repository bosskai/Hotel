package hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bosskai on 2014/11/13.
 */
public class HotelReservation {
    public String bestChoice(List<Hotel> hotelList, final String date, final String customerType, final String specialDate) throws Exception {

        final List<Date> listDate = parseDate(date);
        final List<Date> listSpecialDate = parseDate(specialDate);

        Collections.sort(hotelList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Hotel hotel1 = (Hotel) o1;
                Hotel hotel2 = (Hotel) o2;
                Double totalPrice1 = null;
                Double totalPrice2 = null;
                try {
                    totalPrice1 = hotel1.calculatePrice(listDate, customerType, listSpecialDate);
                    totalPrice2 = hotel2.calculatePrice(listDate, customerType, listSpecialDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (totalPrice1 < totalPrice2) {
                    return -1;
                } else if (totalPrice1 > totalPrice2) {
                    return 1;
                } else {
                    if (hotel1.getRating() > hotel2.getRating()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        return hotelList.get(0).getHotelName();
    }

    private List<Date> parseDate(String date) throws ParseException {
        List<Date> listDate = new ArrayList<Date>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateArray = date.split(",");
        for (String dateString : dateArray) {
            listDate.add(format.parse(dateString));
        }
        return listDate;
    }

}
