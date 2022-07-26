package br.com.erudio.services;

public class MathServices {
    public static Double convertToDouble(String strNumber) {
        if(strNumber == null) {
            return 0D;
        }

        String number = strNumber.replaceAll(",", ".");

        if(isNumericString(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

    public static boolean isNumericString(String strNumber) {
        if(strNumber == null) {
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public static Double substraction(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public static Double division(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;
    }

    public static Double multiplication(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public static Double squareRoot(Double number){
        return Math.sqrt(number);
    }
}
