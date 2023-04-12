import java.util.TreeMap;

class RomanNumbers {
        static String toRoman(int number) {
        TreeMap<Integer, String> numbers = new TreeMap<>();
            numbers.put(100, "C");
            numbers.put(90, "XC");
            numbers.put(50, "L");
            numbers.put(40, "XL");
            numbers.put(10, "X");
            numbers.put(9, "IX");
            numbers.put(5, "V");
            numbers.put(4, "IV");
            numbers.put(1, "I");

        int n = numbers.floorKey(number);
        if (number == n)
            return numbers.get(number);
        return numbers.get(n) + toRoman(number-n);
    }

    static int toArab(String romanNumber) {
        TreeMap<String, Integer> numbers = new TreeMap<>();
        numbers.put("X", 10);
        numbers.put("IX", 9);
        numbers.put("V", 5);
        numbers.put("IV", 4);
        numbers.put("I", 1);

        int tmp = 0;
        int convertedNumber = 0;

        for (String letter : romanNumber.split("")) {
            convertedNumber += tmp < numbers.get(letter) ? numbers.get(letter) - tmp * 2 : numbers.get(letter);
            tmp = numbers.get(letter);
        }
        return convertedNumber;
    }
}
