package hotelreservation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bosskai on 2014/11/12.
 */
public class Hotel {
    private String hotelName;
    private int rating;
    private double weekdayPriceForRegularCustomer;
    private double weekdayPriceForRewardsCustomer;
    private double weekendPriceForRegularCustomer;
    private double weekendPriceForRewardsCustomer;

    public Hotel(String hotelName, int rating, double weekdayPriceForRegularCustomer, double weekdayPriceForRewardsCustomer, double weekendPriceForRegularCustomer, double weekendPriceForRewardsCustomer) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayPriceForRegularCustomer = weekdayPriceForRegularCustomer;
        this.weekdayPriceForRewardsCustomer = weekdayPriceForRewardsCustomer;
        this.weekendPriceForRegularCustomer = weekendPriceForRegularCustomer;
        this.weekendPriceForRewardsCustomer = weekendPriceForRewardsCustomer;
    }

    public Double calculatePrice(List<Date> dateList, String customerType) throws Exception {
        double totalPrice = 0;
        double weekdayPrice;
        double weekendPrice;
        if (customerType.equalsIgnoreCase("rewards")) {
            weekdayPrice = weekdayPriceForRewardsCustomer;
            weekendPrice = weekendPriceForRewardsCustomer;
        } else {
            weekdayPrice = weekdayPriceForRegularCustomer;
            weekendPrice = weekendPriceForRegularCustomer;
        }
        for (Date date : dateList) {
            if (isWeekend(date)) {
                totalPrice += weekendPrice;
            } else {
                totalPrice += weekdayPrice;
            }
        }
        return totalPrice;
    }

    private boolean isWeekend(Date date) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek > 5;
    }

    public int getRating() {
        return rating;
    }

    public String getHotelName() {
        return hotelName;
    }

}
