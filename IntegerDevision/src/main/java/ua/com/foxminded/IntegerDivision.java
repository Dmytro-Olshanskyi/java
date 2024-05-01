package ua.com.foxminded;

import java.util.List;
import java.util.ArrayList;

public class IntegerDivision {

    public String numbersLongDivision(int dividend, int divisor) throws IllegalArgumentException {

        if (dividend == 0 || divisor == 0) {
            throw new IllegalArgumentException("Input parameters contain 0");
        }

        Integer result = dividend / divisor; //Result of division needs to calculate mid-flight results
        StringBuilder resultString = new StringBuilder();

        List<Integer> dividendNumberList = numbersToList(dividend);
        List<Integer> resultNumberList = numbersToList(result);

        if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend is less than divisor");
        }

        //Concatenate numbers if first grade less than divisor to prepare for the first iteration of division
        for (int i = 0; i < dividendNumberList.size(); ) {
            if (dividendNumberList.get(0) < divisor) {
                dividendNumberList.set(0, Integer.parseInt(Integer.toString(dividendNumberList.get(0)) + Integer.toString(dividendNumberList.get(i + 1))));
                dividendNumberList.remove(i + 1);
            } else {
                break;
            }
        }

        String inputData = String.format("_%d|%d\n", dividend, divisor);
        resultString.append(inputData);

       if (divisor == 1) {
           return formateOutputForDivisorOne(dividend, result, resultString);
        }

        int gradeDividendNumber = dividendNumberList.get(0); // The first grade of dividend
        int largestWholeNumber = 0;
        int reminder = 0;

        for (int i = 0; i < dividendNumberList.size(); i++) {

            largestWholeNumber = resultNumberList.get(i) * divisor;
            reminder = gradeDividendNumber - largestWholeNumber;

            if (i < dividendNumberList.size() - 1) {
                gradeDividendNumber = concatenateNumbers(reminder, dividendNumberList.get(i + 1));
            } else {
                gradeDividendNumber = reminder;
            }

            if (i == 0) {

                resultString = formatFirstLineOfOutput(dividend, largestWholeNumber, gradeDividendNumber, result, resultString);

            } else if (i == 1) {

                resultString = formatSecondLineofOutput(i, dividend, largestWholeNumber, gradeDividendNumber, result, resultString);

            } else {

                resultString = formateGenralOutput(i, dividend, largestWholeNumber, gradeDividendNumber, result, resultString, dividendNumberList);


            }
        }
        System.out.println(resultString.toString());

        return resultString.toString();
    }

    private String formateOutputForDivisorOne(int dividend, int result, StringBuilder resultString) {
        resultString.append(" " + String.valueOf(dividend) + "|");
        for (int j = 0; j < String.valueOf(result).length(); j++) {
            resultString.append("-");
        }
        resultString.append("\n");

        resultString.append(" ");
        for (int j = 0; j < String.valueOf(result).length(); j++) {
            resultString.append("-");
        }

        resultString.append("|" + String.valueOf(result));
        resultString.append("\n");

        for (int j = 0; j < String.valueOf(result).length(); j++) {
            resultString.append(" ");
        }
        resultString.append("0");

        return resultString.toString();
    }


    private StringBuilder formatFirstLineOfOutput(int dividend, int largestWholeNumber, int gradeDividendNumber, int result, StringBuilder resultString) {
        String tempLargeWholeNumber = String.format("%1$" + "s"
                        + "%2$" + "d"
                        + "%3$" + (String.valueOf(dividend).length() - String.valueOf(largestWholeNumber).length()) + "s"
                        + "%4$" + "s",
                " ", largestWholeNumber, " ", "|");

        resultString.append(tempLargeWholeNumber);

        for (int j = 0; j < String.valueOf(result).length(); j++) {
            resultString.append("-");
        }

        resultString.append("\n").append(" ");

        for (int j = 0; j < String.valueOf(largestWholeNumber).length(); j++) {
            resultString.append("-");
        }

        String spaceMain = String.format("%1$" + "s"
                        + "%2$" + (String.valueOf(dividend).length() - String.valueOf(largestWholeNumber).length()) + "s"
                        + "%3$" + "d",
                " ", "|", result);

        resultString.append(spaceMain);
        resultString.append("\n");

        String tempGradeDividendNumber = String.format("%1$" + "s"
                        + "%2$" + "d",
                "_", gradeDividendNumber);

        resultString.append(tempGradeDividendNumber);
        resultString.append("\n");

        return resultString;
    }

    private StringBuilder formatSecondLineofOutput(int i, int dividend, int largestWholeNumber, int gradeDividendNumber, int result, StringBuilder resultString) {

        String tempShiftLargestWholeNumber = String.format("%1$" + i + "s"
                        + "%2$" + "d",
                " ", largestWholeNumber);
        String tempShiftGradeDividendNumber = String.format("%1$" + i + "s"
                        + "%2$" + "s"
                        + "%3$" + "d",
                " ", "_", gradeDividendNumber);
        resultString.append(tempShiftLargestWholeNumber).append("\n");

        String space = String.format("%1$" + i + "s", " ");
        resultString.append(space);
        for (int j = 0; j < String.valueOf(largestWholeNumber).length(); j++) {
            resultString.append("-");
        }
        resultString.append("\n");
        resultString.append(tempShiftGradeDividendNumber).append("\n");
        return resultString;
    }

    private StringBuilder formateGenralOutput(int i, int dividend, int largestWholeNumber, int gradeDividendNumber, Integer result, StringBuilder resultString, List<Integer> dividendNumberList) {

        String tempShiftLargestWholeNumber = String.format("%1$" + "s"
                        + "%2$" + (i + 1) + "d",
                " ", largestWholeNumber);

        String tempShiftGradeDividendNumber;
        if (i == dividendNumberList.size() - 1) {
            tempShiftGradeDividendNumber = String.format("%1$" + (i + 1) + "s"
                            + "%3$" + "d",
                    " ", "_", gradeDividendNumber);
        } else {
            tempShiftGradeDividendNumber = String.format("%1$" + i + "s"
                            + "%2$" + "s"
                            + "%3$" + "d",
                    " ", "_", gradeDividendNumber);
        }
        resultString.append(tempShiftLargestWholeNumber).append("\n");
        String space = String.format("%1$" + i + "s", " ");
        resultString.append(space);

        for (int j = 0; j < String.valueOf(largestWholeNumber).length(); j++) {
            resultString.append("-");
        }

        resultString.append("\n");
        resultString.append(tempShiftGradeDividendNumber).append("\n");


        return resultString;
    }

    private int concatenateNumbers(int remainder, int nextInt) {

        int catNum = Integer.parseInt(Integer.toString(remainder) + Integer.toString(nextInt));

        return catNum;
    }

    private List numbersToList(int number) {

        String tempNumberString = Integer.toString(number);
        char[] tempNumberCharArray = new char[tempNumberString.length()];
        tempNumberCharArray = tempNumberString.toCharArray();
        List<Integer> numberList = new ArrayList<Integer>(tempNumberCharArray.length);

        for (char numberAsChar : tempNumberCharArray) {
            numberList.add(Integer.parseInt(String.valueOf(numberAsChar)));
        }

        return numberList;
    }

}
