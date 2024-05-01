package ua.com.foxminded;

import jdk.swing.interop.SwingInterOpUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class MaineTest {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    public static void main(String[] args) {

        String timeStart = "12:02:58.912";
        String timeEnd = "12:15:24.067";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalTime startLdt = LocalTime.parse(timeStart, dtf);
        LocalTime endLdt = LocalTime.parse(timeEnd, dtf);

        System.out.println(startLdt);
        System.out.println(endLdt);


        Duration duration = Duration.between(startLdt, endLdt);
        System.out.println(duration);

        System.out.println("Hours: " + duration.toHoursPart());
        System.out.println("Minutes: " + duration.toMinutesPart());
        System.out.println("Seconds: " + duration.toSecondsPart());
        System.out.println("MSeconds: " + duration.toMillisPart());




    }
}

