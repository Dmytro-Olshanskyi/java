package ua.com.foxminded;

import java.util.function.*;
public class Bubble {

    public final int m;
    public Bubble(int n) {
        this.m = n;
    }
    @Override public String toString(){
        return "Bubble(" + m + ")";
    }
    private static int count = 0;
    public static Bubble bubbler(){
        return new Bubble(count++);
    }
}
