import java.util.Map;
import java.util.TreeMap;

class RomanNumbers {
    private static final TreeMap<Integer, String> numbers = new TreeMap<>();

    static {
        numbers.put(100, "C");
        numbers.put(90, "XC");
        numbers.put(50, "L");
        numbers.put(40, "XL");
        numbers.put(10, "X");
        numbers.put(9, "IX");
        numbers.put(5, "V");
        numbers.put(4, "IV");
        numbers.put(1, "I");
    }

    static String toRoman(int number) {
        int n = numbers.floorKey(number);
        return number == n ? numbers.get(number) : numbers.get(n) + toRoman(number - n);
    }

    static int toArab(String romanNumber) {
        int tmp = 0;
        int convertedNumber = 0;

        for (String letter : romanNumber.split("")) {
            for (Map.Entry<Integer, String> pairs : numbers.entrySet()) {
                if (letter.equals(pairs.getValue())) {
                    convertedNumber += tmp < pairs.getKey() ? pairs.getKey() - tmp * 2 : pairs.getKey();
                    tmp = pairs.getKey();
                }
            }
        }
        return convertedNumber;
    }
}
