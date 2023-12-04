package day1;

/*
* Your calculation isn't quite right.
* It looks like some of the digits are actually spelled out with letters:
* one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".

Equipped with this new information, you now need to find the real first
* and last digit on each line. For example:

two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76.
* Adding these together produces 281.

What is the sum of all of the calibration values?
* */

public class PartTwo {

    private static final String input = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
            """;

    public static int trebuchet(String input) {
        String[] arr = input.split("\n");
        int sum = 0;

        for (String str : arr) {
            String tmp = "";
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    tmp += String.valueOf(str.charAt(i));
                    break;
                }
                int j = i + 1;
                String letterNumber = String.valueOf(str.charAt(i));
                while (j < str.length()) {
                    letterNumber += String.valueOf(str.charAt(j));
                    if (!letterNumberToNumber(letterNumber).isEmpty()) {
                        tmp += letterNumberToNumber(letterNumber);
                        break;
                    }
                    j++;
                }
                if (tmp.length() == 1) {
                    break;
                }
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                if (Character.isDigit(str.charAt(i))) {
                    tmp += String.valueOf(str.charAt(i));
                    break;
                }
                int j = i - 1;
                StringBuilder letterNumber = new StringBuilder(String.valueOf(str.charAt(i)));
                while (j >= 0) {
                    letterNumber.append(str.charAt(j));
                    if (!letterNumberToNumber(letterNumber.reverse().toString()).isEmpty()) {
                        tmp += letterNumberToNumber(letterNumber.toString());
                        break;
                    } else {
                        letterNumber.reverse();
                    }
                    j--;
                }
                if (tmp.length() == 2) {
                    break;
                }
            }
            sum += Integer.parseInt(tmp);
        }
        return sum;
    }

    public static String letterNumberToNumber(String str) {
        return switch (str) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            case "zero" -> "0";
            default -> "";
        };
    }

    public static void main(String[] args) {
        System.out.println(trebuchet(PartOne.input));
    }
}
