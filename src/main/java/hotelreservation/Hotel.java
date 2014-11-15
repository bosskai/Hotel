package hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private String specialDateBegin = "";
    private String specialDateEnd = "";

    public Hotel(String hotelName, int rating, double weekdayPriceForRegularCustomer, double weekdayPriceForRewardsCustomer, double weekendPriceForRegularCustomer, double weekendPriceForRewardsCustomer) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayPriceForRegularCustomer = weekdayPriceForRegularCustomer;
        this.weekdayPriceForRewardsCustomer = weekdayPriceForRewardsCustomer;
        this.weekendPriceForRegularCustomer = weekendPriceForRegularCustomer;
        this.weekendPriceForRewardsCustomer = weekendPriceForRewardsCustomer;
    }

    public Hotel(String hotelName, int rating, double weekdayPriceForRegularCustomer, double weekdayPriceForRewardsCustomer, double weekendPriceForRegularCustomer, double weekendPriceForRewardsCustomer, String specialDateBegin, String specialDateEnd) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayPriceForRegularCustomer = weekdayPriceForRegularCustomer;
        this.weekdayPriceForRewardsCustomer = weekdayPriceForRewardsCustomer;
        this.weekendPriceForRegularCustomer = weekendPriceForRegularCustomer;
        this.weekendPriceForRewardsCustomer = weekendPriceForRewardsCustomer;
        this.specialDateBegin = specialDateBegin;
        this.specialDateEnd = specialDateEnd;
    }

    public Double calculatePrice(List<Date> dateList, String customerType) throws Exception {
        double totalPrice = 0;
        double weekdayPrice;
        double weekendPrice;

        for (Date date : dateList) {
            if (customerType.equalsIgnoreCase("rewards") && !isSpecialDate(date)) {
                weekdayPrice = weekdayPriceForRewardsCustomer;
                weekendPrice = weekendPriceForRewardsCustomer;
            } else {
                weekdayPrice = weekdayPriceForRegularCustomer;
                weekendPrice = weekendPriceForRegularCustomer;
            }
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

    private boolean isSpecialDate(Date date) throws ParseException {
        if (specialDateBegin.isEmpty() || specialDateEnd.isEmpty()) {
            return false;
        }
        Calendar s = Calendar.getInstance();
        s.setTime(date);
        int designatedDateYear = s.get(Calendar.YEAR);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date containsYearSpecialDateBegin = format.parse(designatedDateYear + "-" + specialDateBegin);
        Date containsYearSpecialDateEnd = format.parse(designatedDateYear + "-" + specialDateEnd);

        if (!containsYearSpecialDateEnd.after(containsYearSpecialDateBegin)) {
            containsYearSpecialDateEnd = format.parse(designatedDateYear + 1 + "-" + specialDateEnd);
        }
        boolean isAfterSpecialDateBegin = date.after(containsYearSpecialDateBegin)
                || date.equals(containsYearSpecialDateBegin);
        boolean isBeforeSpecialDateEnd = date.before(containsYearSpecialDateEnd)
                || date.equals(containsYearSpecialDateEnd);
        if ((isAfterSpecialDateBegin) && (isBeforeSpecialDateEnd)) {
            return true;
        } else {
            return false;
        }
    }

    public int getRating() {
        return rating;
    }

    public String getHotelName() {
        return hotelName;
    }

}
