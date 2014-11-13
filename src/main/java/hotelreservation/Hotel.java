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

    public Double  calculatePrice(List<Date> dateList, String customerType) throws Exception {
        double totalPrice = 0;
        double weekdayPrice = customerType.equalsIgnoreCase("rewards") ? weekdayPriceForRewardsCustomer : weekdayPriceForRegularCustomer;
        double weekendPrice = customerType.equalsIgnoreCase("rewards") ? weekendPriceForRewardsCustomer : weekendPriceForRegularCustomer;
        for (Date date : dateList) {
            if (getDay(date) > 5) {
                totalPrice += weekendPrice;
            } else {
                totalPrice += weekdayPrice;
            }
        }
        return totalPrice;
    }

    private int getDay(Date date) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    public int getRating() {
        return rating;
    }

    public String getHotelName() {
        return hotelName;
    }

}
