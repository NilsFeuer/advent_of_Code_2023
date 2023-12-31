package day15;

import java.util.List;
import util.InputUtil;

public class LensLibrary {

    public static void lensLibrary(String inputFile) {
        List<String> input = InputUtil.readInput(inputFile);

        Box[] boxes = new Box[256];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box();
        }

        long sumPartOne = 0;
        long sumPartTwo = 0;

        for (String s : input.get(0).split(",")) {
            String[] seq = searchLabel(s);
            int boxNumber = hashAlgo(seq[0]);
            if (seq[1].equals("-")) {
                boxes[boxNumber].removeLabel(seq[0]);
            } else {
                boxes[boxNumber].addLabel(seq[0], seq[2]);
            }
        }

        int index = 0;
        for (Box b : boxes) {
            for (int i = 0; i < b.labels.size(); i++) {
                long x = (long) (1 + index) * (i + 1) * Integer.parseInt(b.labels.get(i)[1]);
                sumPartTwo += x;
            }
            index++;
        }

        for (String s : input.get(0).split(",")) {
            sumPartOne += hashAlgo(s);
        }

        System.out.println("Solution Part One: " + sumPartOne);
        System.out.println("Solution Part Two: " + sumPartTwo);
    }

    private static int hashAlgo(String s) {
        int value = 0;
        for (Character c : s.toCharArray()) {
            value += (int) c;
            value *= 17;
            value = value % 256;
        }
        return value;
    }

    private static String[] searchLabel(String str) {
        String[] arr = new String[3];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || str.charAt(i) == '=') {
                arr[0] = str.substring(0, i);
                arr[1] = str.substring(i, i + 1);
                arr[2] = str.substring(i + 1);
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        lensLibrary("day15.txt");
    }
}
