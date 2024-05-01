package ua.com.foxminded;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    String str1 = "hello    world olllollo";
    String str2 = "hello word";

    str1 = str1.replaceAll("\\s","");  //remove spaces
   //String[] words = str1.split(" ");
// Для кеша используем хешмап хешмапов. В первом как ключь используем хешь, во втором добавлять плюс один если такая буква как ключь уже есть.
    //String word = words[0];

        List<Character> strList = str1.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList()); // convert string to list

        for (char ch: strList) {

            long countL = strList.stream().filter(i -> i == ch).count();

            System.out.println("\"" + ch + "\" - " + countL);
        }
        //System.out.println(str1.hashCode());
        //System.out.println(str2.hashCode());

    /*    StringBuilder expected = new StringBuilder();
        expected.append("_" + String.valueOf(dividend) + "|" + String.valueOf(divisor)).append("\n");
        expected.append(" " + String.valueOf(dividend) + "|---").append("\n");
        expected.append(" " + "---|" + String.valueOf(123)).append("\n");
        expected.append("   " + String.valueOf(0));

        System.out.println(expected.toString());

    /*    int dividend = 353464;
        int divisor = 5;
        //String inputData = String.format(" %d|%d\n", dividend, divisor) + insert(dividend, divisor);
        //System.out.println(inputData);

        //IntegerDivision2 id1 = new IntegerDivision2();
        //System.out.println(id1.numbersLongDivision(74832, 2));
        IntegerDivision1 id1 = new IntegerDivision1();
        System.out.println(id1.division(74832, 2));

       /* private static String insert (int dividend, int divisor){
            int lengthDivined = String.valueOf(dividend).length();
            int quotient = String.valueOf(dividend/divisor).length();
            StringBuilder string = new StringBuilder(" ");
            for (int i = 0; i < lengthDivined; i++){
                string.append(" ");
            }
            string.append("|");
            for (int i = 0; i < quotient; i++){
                string.append("-");
            }
            string.append("\n").append(" ");
            for (int i = 0; i < lengthDivined; i++){
                string.append("_");
            }
            string.append("|").append(dividend/divisor).append("\n");
            return string.toString();
        } */

    }
}



