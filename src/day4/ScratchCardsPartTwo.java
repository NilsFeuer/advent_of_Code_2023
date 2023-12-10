package day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScratchCardsPartTwo {

    public static Long scratchCards(String input) {
        String[] arr = input.split("\n");
        List<String> winningNumbers = new ArrayList<>();
        List<Long> numbersOfWonCards = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            numbersOfWonCards.add(1L);
        }

        int cardPoints = 0;

        for (int j = 0; j < arr.length; j++) {
            int index = 0;
            for (int i = 0; i < arr[j].length(); i++) {
                if (arr[j].charAt(i) == ':') {
                    index = i + 2;
                    break;
                }
            }
            String tmp = "";
            for (int i = index; i < arr[j].length(); i++) {
                if (Character.isDigit(arr[j].charAt(i))) {
                    tmp += arr[j].charAt(i);
                } else if (arr[j].charAt(i) == ' ') {
                    if (!tmp.isEmpty()) {
                        winningNumbers.add(tmp);
                    }
                    tmp = "";
                }
                if (arr[j].charAt(i) == '|') {
                    index = i + 1;
                    tmp = "";
                    break;
                }
            }
            for (int i = index; i < arr[j].length(); i++) {
                if (Character.isDigit(arr[j].charAt(i))) {
                    tmp += arr[j].charAt(i);
                }
                if (arr[j].charAt(i) == ' ' || i == arr[j].length() - 1) {
                    if (winningNumbers.contains(tmp)) {
                        cardPoints++;
                    }
                    tmp = "";
                }
            }
            int card = j + 1;
            for (int i = 1; i <= cardPoints; i++) {
                if (card <= arr.length - 1) {
                    Long value = numbersOfWonCards.get(card) + numbersOfWonCards.get(j);
                    numbersOfWonCards.set(card, value);
                } else {
                    break;
                }
                card++;
            }
            cardPoints = 0;
            winningNumbers.clear();
        }
        return numbersOfWonCards.stream().reduce(0L, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        System.out.println(scratchCards(ScratchcardsPartOne.input));
    }
}
