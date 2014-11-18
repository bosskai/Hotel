package hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bosskai on 2014/11/13.
 */
public class HotelReservation {
    protected List<Hotel> hotelList;

    public HotelReservation() {
        hotelList = new ArrayList<Hotel>();
        Hotel lakeWood = new Hotel("LakeWood", 3, 110, 80, 90, 80);
        Hotel bridgeWood = new Hotel("BridgeWood", 4, 160, 110, 60, 50);
        Hotel ridgeWood = new Hotel("RidgeWood", 5, 220, 100, 150, 40);
        hotelList.add(lakeWood);
        hotelList.add(bridgeWood);
        hotelList.add(ridgeWood);
    }

    public String bestChoice(final String date) throws Exception {

        String dateFormat = date.replace(" ", "");

        String[] Array = dateFormat.split(":");
        String customerType = customerType = Array[0];
        String needToFormatDate = needToFormatDate = Array[1];

        final List<Date> listDate = parseDate(needToFormatDate);


        final String finalCustomerType = customerType;
        Collections.sort(hotelList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Hotel hotel1 = (Hotel) o1;
                Hotel hotel2 = (Hotel) o2;
                Double totalPrice1 = null;
                Double totalPrice2 = null;
                try {
                    totalPrice1 = hotel1.calculatePrice(listDate, finalCustomerType);
                    totalPrice2 = hotel2.calculatePrice(listDate, finalCustomerType);
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

    protected List<Date> parseDate(String date) throws ParseException {
        List<Date> listDate = new ArrayList<Date>();
        String[] dateArray = date.split(",");
        DateFormat format = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
        for (String dateString : dateArray) {
            listDate.add(format.parse(dateString.split("\\(")[0]));
        }
        return listDate;
    }
}
