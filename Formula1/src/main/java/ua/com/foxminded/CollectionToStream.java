package ua.com.foxminded;

import java.util.*;
import java.util.stream.*;

public class CollectionToStream {
    public static void main(String[] args) {
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        System.out.println(

                bubbles.stream()
                .mapToInt(b -> b.m)
                .sorted()

        );
    }
}
