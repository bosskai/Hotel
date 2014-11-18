package hotelreservation;

import java.io.*;

/**
 * Created by bosskai on 2014/11/18.
 */
public class HotelReservationMain {
    public static void main(String[] args) throws Exception {
        File file = new File("src/main/java/res/inputTest.txt");
        String encoding = "GBK";
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file), encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                HotelReservation hotelReservation = new HotelReservation();
                System.out.println("Name of the cheapest hotel:" + hotelReservation.bestChoice(lineTxt));
            }
            read.close();
        } else {
            System.out.println("Can't find the file specified\n");
        }
    }


}
