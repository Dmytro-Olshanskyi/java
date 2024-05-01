package ua.com.foxminded;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BestLapTime {
    Racer driver;
    String start;
    String end;
    long lapTime;

    public BestLapTime(Racer driver, String start, String end) throws ParseException {
        this.driver = driver;
        this.start = start;
        this.end = end;
        this.lapTime = getLapTime(start, end);
    }

    private long getLapTime(String start, String end) throws ParseException {

        long lapTime;
        Date startDate = new SimpleDateFormat("HH:mm:ss.SSS").parse(start);
        Date endDate = new SimpleDateFormat("HH:mm:ss.SSS").parse(end);

        SimpleDateFormat formatter = new SimpleDateFormat("HHmmssSSS");
        lapTime = endDate.getTime() - startDate.getTime();
        return lapTime;
    }

    public Racer getDriver() {
        return driver;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public long getLapTime() {
        return lapTime;
    }

}
