package ua.com.foxminded;

public class IntegerDivision2 {

    public String numbersLongDivision(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder("");
        StringBuilder quotient = new StringBuilder();

        String outputData;
        Integer reminderNumber;
        Integer mod;

        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0");
        }

        String[] arrDivisor = String.valueOf(dividend).split("");
        outputData = String.format(" %d|%d\n", dividend, divisor) + insert(dividend, divisor);

        for (int i = 0; i < arrDivisor.length; i++) {
            temp.append(arrDivisor[i]);
            reminderNumber = Integer.parseInt(temp.toString());

        }

        return outputData+result.toString();
    }

        private String insert (int dividend, int divisor){
            int lengthDivined = String.valueOf(dividend).length();
            int quotient = String.valueOf(dividend/divisor).length();
            StringBuilder string = new StringBuilder(" ");
            for (int i = 0; i < lengthDivined; i++){
                string.append("-");
            }
            string.append("|");
            for (int i = 0; i < quotient; i++){
                string.append("-");
            }
            string.append(" ");
            for (int i = 0; i < lengthDivined; i++){
                string.append("-");
            }
            string.append("|").append(dividend/divisor).append("\n");
            return string.toString();
        }
}
