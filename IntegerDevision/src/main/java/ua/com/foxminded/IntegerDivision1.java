package ua.com.foxminded;
public class IntegerDivision1 {

    public String division(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder("");
        StringBuilder quotient = new StringBuilder();
        String  inputData;
        Integer reminderNumber;
        Integer mod;


        if (divisor==0){
            throw new IllegalArgumentException("Divisor cannot be 0");
        }

        String[] arrDivisor = String.valueOf(dividend).split("");
        inputData = String.format(" %d|%d\n",dividend,divisor)+ insert(dividend,divisor);

        for(int i = 0 ; i < arrDivisor.length; i++){
            temp.append(arrDivisor[i]);
            reminderNumber = Integer.parseInt(temp.toString());


            if(reminderNumber >= divisor){
                quotient.append(reminderNumber/divisor);
                mod = reminderNumber%divisor;
                long multiplyResult = reminderNumber/divisor*divisor;
                temp.replace(0, temp.length(), mod.toString());

                String firstLine = String.format("%" + (i + 2) + "s", "_" + reminderNumber.toString());
                result.append(firstLine).append("\n");

                String secondLine = String.format("%" + (i + 2) + "d", multiplyResult);
                result.append(secondLine).append("\n");
            }
        }
        return inputData+result.toString();
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
        string.append(" ").append("\n");
        for (int i = 0; i < lengthDivined; i++){
            string.append("-");
        }
        string.append("|").append(dividend/divisor).append("\n");
        return string.toString();

    }
}
