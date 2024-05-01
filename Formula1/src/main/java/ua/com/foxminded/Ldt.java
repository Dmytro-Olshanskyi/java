package ua.com.foxminded;
import javax.swing.plaf.metal.MetalBorders;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ldt {
    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY-MM-dd");

        System.out.println(dtf.format(localDateTime));

        String str = "SVF2018-05-24_12:02:58.917";

        String abreviation = str.substring(0,3);
        String date = str.substring(3);



        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        LocalDateTime start = LocalDateTime.parse(date, dtf);
        System.out.println(start);
    }
}
