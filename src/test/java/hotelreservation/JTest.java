package test.hotelreservation;

import main.java.hotelreservation.Hotel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bosskai on 2014/11/12.
 */
public class JTest {

    public static void main(String[] args) throws Exception {
        Hotel lakeWood = new Hotel(hotelName, 3, 110, 80, 90, 80);

        Hotel bridgeWood = new Hotel(hotelName, 4, 160, 110, 60, 50);

        Hotel ridgeWood = new Hotel(hotelName, 5, 160, 110, 60, 50);

        List<String> date = new ArrayList<String>();
//        Scanner s =new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("lakeWood:"+lakeWood.getWeekdayPriceForRewardsCustomer());
        System.out.println("Please input array separated by Spaces:");
        System.out.println("Please enter the date format as yyyy-MM-dd:");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = sc.nextLine();
        String[] split = str.trim().split("\\s{1,}");
        date = Arrays.asList(split);

//        double customerType = 0;
        double lakeWoodPrice = 0;
        double bridgeWoodPrice = 0;
        double ridgeWoodPrice = 0;
        lakeWoodPrice = lakeWood.calculatePrice(date, 0);
        bridgeWoodPrice = bridgeWood.calculatePrice(date, 0);
        ridgeWoodPrice = ridgeWood.calculatePrice(date, 0);
        System.out.println("The most suitable hotel:" + priceOperation(lakeWoodPrice, bridgeWoodPrice, ridgeWoodPrice));
        System.out.println("The most suitable w:" + lakeWoodPrice+bridgeWoodPrice+ridgeWoodPrice+"ss");
    }

    protected static String priceOperation(double lakeWoodPrice, double bridgeWoodPrice, double ridgeWoodPrice) {
        String hotelName = "";

        hotelName = lakeWoodPrice == bridgeWoodPrice ? "BridgeWood" : "";
        hotelName = lakeWoodPrice == ridgeWoodPrice ? "RidgeWood" : "";
        hotelName = bridgeWoodPrice == ridgeWoodPrice ? "RidgeWood" : "";
//        double[] arr={lakeWoodPrice,bridgeWoodPrice,bridgeWoodPrice};
//        double min=arr[0];
//        for(int i=0;i<arr.length;i++) {
//            if (arr[i] < arr[0]) {
//                min = arr[i];
//            }
//        }
        int firstGroup = compare(new BigDecimal(lakeWoodPrice),new BigDecimal(bridgeWoodPrice));
        int secondGroup = compare(new BigDecimal(lakeWoodPrice),new BigDecimal(ridgeWoodPrice));
        int thirdGroup = compare(new BigDecimal(bridgeWoodPrice),new BigDecimal(ridgeWoodPrice));
        hotelName = firstGroup == 1 ? "BridgeWood" : "LakeWood";
        hotelName = secondGroup == 1 ? "RidgeWood" : "LakeWood";
        hotelName = thirdGroup == 1 ? "RidgeWood" : "BridgeWood";
        return hotelName;
    }

    public static int compare(BigDecimal val1, BigDecimal val2) {
        int result = 0;
        if (val1.compareTo(val2) < 0) {
            result = -1;
        }
        if (val1.compareTo(val2) == 0) {
            result = 0;
        }
        if (val1.compareTo(val2) > 0) {
            result = 1;
        }
        return result;
    }



}
