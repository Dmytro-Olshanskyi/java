package ua.com.foxminded;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupBuilder {

    private static final int ASCII_A = 65;
    private static final int ASCII_Z = 90;
    private static final int ASCII_0 = 48;
    private static final int ASCII_9 = 57;

    private static final int CHAR_NUMBER = 2;
    private static final int NUM_NUMBER = 2;
    private static final String SEPARATOR = "-";

    private static final Random random = new Random();
    private static final StringBuilder sb = new StringBuilder();



    public List<Group> generateGroupList(int groupNumber){
        List<Group> groupList = new ArrayList<>();
        for(int i = 1; i <= groupNumber; i++){

            groupList.add(new Group(i, generateGroupName()));
        }

        return groupList;

    }
    private String generateGroupName(){
        sb.setLength(0);
        // StringBuilder sb = new StringBuilder();
        sb.append(generateGroupNamePart(ASCII_A, ASCII_Z, CHAR_NUMBER));
        sb.append(SEPARATOR);
        sb.append(generateGroupNamePart(ASCII_0, ASCII_9, NUM_NUMBER));

        System.out.println(sb);

        return sb.toString();
    }

    private String generateGroupNamePart(int leftLimit, int rightLimit, int stringLength){

       // Random random = new Random();

        String generatedString = random.ints(stringLength, leftLimit, rightLimit + 1)
               // .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;

    }
}
