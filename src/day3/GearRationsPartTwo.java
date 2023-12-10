package day3;

import java.util.ArrayList;
import java.util.List;

public class GearRationsPartTwo {

    public static Long gearRations(String input) {
        String[] arr = input.split("\n");
        Long sum = 0L;

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[j].length(); i++) {
                if (arr[j].charAt(i) == '*') {
                    List<Long> numbersAround = new ArrayList<>();
                    findPartsAround(arr, j, i, numbersAround);
                    sum += numbersAround.size() == 2 ? numbersAround.get(0) * numbersAround.get(1) : 0;
                }
            }
        }
        return sum;
    }

    private static void findPartsAround(String[] arr, int j, int i, List<Long> numbersAround) {
        if (j > 0) {
            String line = arr[j - 1];
            searchTopOrBottom(line, i, numbersAround);
        }
        if (j < arr.length - 1) {
            String line = arr[j + 1];
            searchTopOrBottom(line, i, numbersAround);
        }
        searchLeftAndRight(arr[j], i, numbersAround);
    }

    private static void searchTopOrBottom(String line, int i, List<Long> numbersAround) {
        char c = line.charAt(i);
        if (Character.isDigit(c)) {
            int left = i - 1;
            while (left >= 0) {
                char d = line.charAt(left);
                if (Character.isDigit(d)) {
                    left--;
                } else {
                    left++;
                    break;
                }
            }
            if (left < 0) {
                left = 0;
            }

            int right = i + 1;
            while (right < line.length()) {
                char d = line.charAt(right);
                if (Character.isDigit(d)) {
                    right++;
                } else {
                    break;
                }
            }
            numbersAround.add(Long.parseLong(line.substring(left, right)));
        }else{
            searchLeftAndRight(line, i, numbersAround);
        }
    }

    private static void searchLeftAndRight(String line, int i, List<Long> numbersAround) {
        int left = i - 1;
        while (left >= 0) {
            char d = line.charAt(left);
            if (Character.isDigit(d)) {
                left--;
            } else {
                left++;
                break;
            }
        }
        if (left < 0) {
            left = 0;
        }
        if (left < i) {
            numbersAround.add(Long.parseLong(line.substring(left, i)));
        }

        int right = i + 1;
        while (right < line.length()) {
            char d = line.charAt(right);
            if (Character.isDigit(d)) {
                right++;
            } else {
                break;
            }
        }
        if (right > i + 1) {
            numbersAround.add(Long.parseLong(line.substring(i + 1, right)));
        }
    }

    public static void main(String[] args) {
        System.out.println(gearRations(GearRatiosPartOne.input));
    }
}
