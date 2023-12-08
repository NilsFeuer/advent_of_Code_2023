package day6;

import java.util.ArrayList;
import java.util.List;

public class WaitForIt {

    public static String exampleInput = """
            Time:      7  15   30
            Distance:  9  40  200
            """;

    public static String input = """
            Time:        47     84     74     67
            Distance:   207   1394   1209   1014
            """;


    //Part One
    public static int waitForIt(String input) {
        String[] arr = input.split("\n");

        int speed;
        int distance = 0;

        int totalNumberOfWaysToBeatRecord = 1;

        List<Integer> times = new ArrayList<>();
        List<Integer> distances = new ArrayList<>();

        for (int j = 0; j < arr.length; j++) {
            String tmp = "";
            for (int i = 0; i < arr[j].length(); i++) {
                if (Character.isDigit(arr[j].charAt(i))) {
                    tmp += arr[j].charAt(i);
                }
                if (arr[j].charAt(i) == ' ' || i == arr[j].length() - 1) {
                    if (!tmp.isEmpty()) {
                        if (j == 0) {
                            times.add(Integer.parseInt(tmp));
                        } else {
                            distances.add(Integer.parseInt(tmp));
                        }
                        tmp = "";
                    }
                }
            }
        }

        for (int i = 0; i < times.size(); i++) {
            int numberToBeatRecord = 0;
            int time = 0;
            while (time < times.get(i)) {
                int remainingTime = times.get(i) - time;
                speed = time;
                distance = speed * remainingTime;
                if (distance > distances.get(i)) {
                    numberToBeatRecord++;
                }
                time++;
            }
            totalNumberOfWaysToBeatRecord *= numberToBeatRecord;
        }
        return totalNumberOfWaysToBeatRecord;
    }

    public static void main(String[] args) {
        System.out.println(waitForIt(input));
    }
}
