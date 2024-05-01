package ua.com.foxminded;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class testTimeDiff {
    public static void main(String[] args) {
        long start = 72013 ;

        DateFormat df = new SimpleDateFormat("mm:ss:SSS");
        Date dayStart = new Date(start);


        System.out.println(df.format(dayStart));
        StringBuilder sb = new StringBuilder(10);
        int n = 10 ;
        int i = 1;

        sb.append(stringFormat("Hello"));
        sb.append(stringFormat("World"));
       // sb.append("|");
        sb.append(stringFormat("World"));
        sb.append("\n");
        sb.append(stringFormat("Hello0000"));
        sb.append(stringFormat("World00"));
        // sb.append("|");
        sb.append(stringFormat("World00"));


        System.out.println(sb);

    }
    private static String stringFormat(String s){
        Formatter fm = new Formatter();
        int width = 10;

       // int padSize = 10;
        //int pad = (width - s.length());
        fm.format("%1$-" + width + "s" + "%2$s" ,s, "|");

        return fm.toString();
    }
}
