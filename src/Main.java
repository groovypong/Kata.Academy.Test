import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println(calc(in.readLine()));
        }
    }

    public static String calc(String input) throws Exception {
        int result = 0;
        boolean operatorIsExist = false;
        boolean isRoman = false;

        for (String s : input.split("")) {
            if ("+-*/".contains(s)) {
                operatorIsExist = true;
                int indexOfOperator = input.indexOf(s);
                String leftPart = input.substring(0, indexOfOperator).trim();
                String rightPart = input.substring(indexOfOperator + 1).trim();
                int a;
                int b;
                try {
                    a = Integer.parseInt(leftPart);
                    b = Integer.parseInt(rightPart);
                } catch (NumberFormatException numberFormatException) {
                    isRoman = true;
                    a = RomanNumbers.toArab(leftPart);
                    b = RomanNumbers.toArab(rightPart);
                }

                if (a > 10 || b > 10)
                    throw new Exception();

                switch (s) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                }
                break;
            }
        }

        if (!operatorIsExist)
            throw new Exception();

        return isRoman ? RomanNumbers.toRoman(result) : String.valueOf(result);
    }
}