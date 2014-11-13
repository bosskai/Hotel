package main.java.hotelreservation;

import main.util.dForW;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bosskai on 2014/11/12.
 */
public class Hotel {
    private String hotelName;
    private int rating;//评级
    private double weekdayPriceForRegularCustomer;//工作日_正常_价格
    private double weekdayPriceForRewardsCustomer;//工作日_会员_价格
    private double weekendPriceForRegularCustomer;//周末_正常_价格
    private double weekendPriceForRewardsCustomer;//周末_会员_价格

    public Hotel(String hotelName, int rating, double weekdayPriceForRegularCustomer, double weekdayPriceForRewardsCustomer, double weekendPriceForRegularCustomer, double weekendPriceForRewardsCustomer) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayPriceForRegularCustomer = weekdayPriceForRegularCustomer;
        this.weekdayPriceForRewardsCustomer = weekdayPriceForRewardsCustomer;
        this.weekdayPriceForRegularCustomer = weekdayPriceForRegularCustomer;
        this.weekendPriceForRewardsCustomer = weekendPriceForRewardsCustomer;
    }


    public Double  calculatePrice(List<String> dateList, double customerType) throws Exception {
        double totalPrice = 0;
        double weekdayPrice = customerType == 1 ? weekdayPriceForRewardsCustomer : weekdayPriceForRegularCustomer;
        double weekendPrice = customerType == 0 ? weekendPriceForRegularCustomer : weekendPriceForRewardsCustomer;
        for (String date : dateList) {
            if (dForW.dayForWeek(date) > 5) {
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


    public double getWeekdayPriceForRegularCustomer() {
        return weekdayPriceForRegularCustomer;
    }


    public double getWeekdayPriceForRewardsCustomer() {
        return weekdayPriceForRewardsCustomer;
    }


    public double getWeekendPriceForRegularCustomer() {
        return weekendPriceForRegularCustomer;
    }


    public double getWeekendPriceForRewardsCustomer() {
        return weekendPriceForRewardsCustomer;
    }


    public String getHotelName() {
        return hotelName;
    }
}
