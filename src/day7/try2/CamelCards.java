package day7.try2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.InputUtil;

public class CamelCards {

    public static void camelCards(String inputFile) {
        List<String> input = InputUtil.readInput(inputFile);

        List<Card> cards = new ArrayList<>();

        long val = 0;

        for (String line : input) {
            cards.add(new Card(line));
        }

        Collections.sort(cards);

        int rank = cards.size();
        for (Card card : cards) {
            card.setRank(rank);
            val += card.getScore();
            rank--;
        }

        System.out.println("Solution Part 2: " + val);
    }

    public static void main(String[] args) {
        camelCards("day7.txt");
    }
}
