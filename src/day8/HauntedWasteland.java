package day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.InputUtil;

public class HauntedWasteland {

    public static Long partOne(String inputFile) {
        Long steps = 0L;
        List<String> input = InputUtil.readInput(inputFile);
        String navigate = input.get(0);
        Map<String, String[]> nodes = new HashMap<>();

        for (int i = 2; i < input.size(); i++) {
            String[] arr = new String[2];
            arr[0] = input.get(i).substring(7, 10);
            arr[1] = input.get(i).substring(12, 15);
            nodes.put(input.get(i).substring(0, 3), arr);
        }

        String currentPlace = "AAA";
        while (!currentPlace.equals("ZZZ")) {
            for (int i = 0; i < navigate.length(); i++) {
                if (navigate.charAt(i) == 'L') {
                    currentPlace = nodes.get(currentPlace)[0];
                }
                if (navigate.charAt(i) == 'R') {
                    currentPlace = nodes.get(currentPlace)[1];
                }
                steps++;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(partOne("day8.txt"));
    }
}
