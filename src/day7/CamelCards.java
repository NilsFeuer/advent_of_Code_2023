package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import util.InputUtil;

import java.util.List;

public class CamelCards {

    public static String exampleInput = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
            """;

    public static Long camelCardsGame(String inputFile) {
        List<String> input = InputUtil.readInput(inputFile);

        List<String> finalOrder = new ArrayList<>();
        List<String> handOrder = new ArrayList<>();

        for (String line : input) {
            String[] splitLine = line.split(" ");
            if (finalOrder.isEmpty()) {
                finalOrder.add(splitLine[1]);
                handOrder.add(splitLine[0]);
            } else {
                int i = 0;
                while (i < handOrder.size() && isHandStronger(handOrder.get(i), splitLine[0])) {
                    i++;
                }
                finalOrder.add(i, splitLine[1]);
                handOrder.add(i, splitLine[0]);
            }
        }

        Long sum = 0L;
        for (int i = 0; i < finalOrder.size(); i++) {
            sum += Long.parseLong(finalOrder.get(i)) * (i + 1);
        }
        return sum;
    }

    private static boolean isHandStronger(String compareHand, String hand) {
        Map<Character, Integer> compareHandType = new HashMap<>();
        Map<Character, Integer> handType = new HashMap<>();

        for (int i = 0; i < hand.length(); i++) {
            if (compareHandType.containsKey(compareHand.charAt(i))) {
                compareHandType.put(compareHand.charAt(i), Integer.valueOf(compareHandType.get(compareHand.charAt(i)) + 1));
            } else {
                compareHandType.put(compareHand.charAt(i), 1);
            }
            if (handType.containsKey(hand.charAt(i))) {
                handType.put(hand.charAt(i), Integer.valueOf(handType.get(hand.charAt(i)) + 1));
            } else {
                handType.put(hand.charAt(i), 1);
            }
        }

        Integer numberOfJokersCompareHand = compareHandType.get('J');
        Integer numberOfJokersHand = handType.get('J');

        Character compareHandChar = Collections.max(compareHandType.entrySet(), Map.Entry.comparingByValue()).getKey();
        Character handChar = Collections.max(handType.entrySet(), Map.Entry.comparingByValue()).getKey();

        if (numberOfJokersHand != null) {
            handType.put(handChar, handType.get(handChar) + numberOfJokersHand);
            handType.remove('J');
        }
        if (numberOfJokersCompareHand != null) {
            compareHandType.put(compareHandChar, compareHandType.get(compareHandChar) + numberOfJokersCompareHand);
            compareHandType.remove('J');
        }


        if (compareHandType.size() == handType.size()) {
            if (!handTypeCheck(new ArrayList<Integer>(compareHandType.values()), new ArrayList<Integer>(handType.values()), compareHand, hand)) {
                return false;
            } else {
                return true;
            }
        }
        if (compareHandType.size() == 1 && handType.size() > 1) {
            return false;
        }
        if (compareHandType.size() == 2 && handType.size() > 2) {
            return false;
        }
        if (compareHandType.size() == 3 && handType.size() > 3) {
            return false;
        }
        if (compareHandType.size() == 4 && handType.size() > 4) {
            return false;
        }
        return true;
    }

    private static boolean handTypeCheck(List<Integer> compareHandList, List<Integer> handList, String compareHand, String hand) {
        Collections.sort(compareHandList);
        Collections.sort(handList);
        if (compareHandList.size() == 2) {
            if (compareHandList.get(1) > handList.get(1)) {
                return false;
            } else if (compareHandList.get(1) == handList.get(1)) {
                return checkHighestCard(compareHand, hand);
            } else {
                return true;
            }
        }
        if (compareHandList.size() == 3) {
            if (compareHandList.get(2) > handList.get(2)) {
                return false;
            } else if (compareHandList.get(2) == handList.get(2)) {
                return checkHighestCard(compareHand, hand);
            } else {
                return true;
            }
        }
        return checkHighestCard(compareHand, hand);
    }

    private static boolean checkHighestCard(String compareHand, String hand) {
        for (int i = 0; i < hand.length(); i++) {
            if (compareHand.charAt(i) == hand.charAt(i)) {
                continue;
            }
            if (compareHand.charAt(i) == 'A') {
                return false;
            } else if (hand.charAt(i) == 'A') {
                return true;
            }
            if (compareHand.charAt(i) == 'K') {
                return false;
            } else if (hand.charAt(i) == 'K') {
                return true;
            }
            if (compareHand.charAt(i) == 'Q') {
                return false;
            } else if (hand.charAt(i) == 'Q') {
                return true;
            }
            if (compareHand.charAt(i) == 'T') {
                return false;
            } else if (hand.charAt(i) == 'T') {
                return true;
            }
            if (compareHand.charAt(i) == '9') {
                return false;
            } else if (hand.charAt(i) == '9') {
                return true;
            }
            if (compareHand.charAt(i) == '8') {
                return false;
            } else if (hand.charAt(i) == '8') {
                return true;
            }
            if (compareHand.charAt(i) == '7') {
                return false;
            } else if (hand.charAt(i) == '7') {
                return true;
            }
            if (compareHand.charAt(i) == '6') {
                return false;
            } else if (hand.charAt(i) == '6') {
                return true;
            }
            if (compareHand.charAt(i) == '5') {
                return false;
            } else if (hand.charAt(i) == '5') {
                return true;
            }
            if (compareHand.charAt(i) == '4') {
                return false;
            } else if (hand.charAt(i) == '4') {
                return true;
            }
            if (compareHand.charAt(i) == '3') {
                return false;
            } else if (hand.charAt(i) == '3') {
                return true;
            }
            if (compareHand.charAt(i) == '2') {
                return false;
            } else if (hand.charAt(i) == '2') {
                return true;
            }
            if (compareHand.charAt(i) == 'J') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Solution day 7 Part one: " + camelCardsGame("day7.txt"));
    }
}
