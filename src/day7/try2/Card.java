package day7.try2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card> {
    static int FIVE_OF_A_KIND = 6;
    static int FOUR_OF_A_KIND = 5;
    static int FULL_HOUSE = 4;
    static int THREE_OF_A_KIND = 3;
    static int TWO_PAR = 2;
    static int ONE_PAR = 1;
    static int HIGH_CARD = 0;

    int type = HIGH_CARD;
    int[] hand = new int[5];
    long bid;
    int[] typeAmound = new int[15];
    private long rank;

    public Card(String line) {
        int i = 0;

        Arrays.fill(typeAmound, 0);

        String[] lineArr = line.split(" ");
        bid = Long.parseLong(lineArr[1]);
        for (String c : lineArr[0].split("")) {
            switch (c) {
                case "A":
                    hand[i] = 14;
                    break;
                case "K":
                    hand[i] = 13;
                    break;
                case "Q":
                    hand[i] = 12;
                    break;
                case "J":
                    hand[i] = 0;
                    break;
                case "T":
                    hand[i] = 10;
                    break;
                case "9":
                    hand[i] = 9;
                    break;
                case "8":
                    hand[i] = 8;
                    break;
                case "7":
                    hand[i] = 7;
                    break;
                case "6":
                    hand[i] = 6;
                    break;
                case "5":
                    hand[i] = 5;
                    break;
                case "4":
                    hand[i] = 4;
                    break;
                case "3":
                    hand[i] = 3;
                    break;
                case "2":
                    hand[i] = 2;
                    break;
            }
            typeAmound[hand[i]]++;

            i++;
        }

        List<Integer> amounts = new ArrayList<>();
        for (int k = 1; k < typeAmound.length; k++) {
            int v = typeAmound[k];
            if (v == 0) {
                continue;
            }
            amounts.add(v);
        }

        if (typeAmound[0] == 5) {
            type = Card.FIVE_OF_A_KIND;
            return;
        }

        Collections.sort(amounts, (a, b) -> b - a);
        boolean usedTypeAmount = false;

        for (int j : amounts) {
            if (!usedTypeAmount) {
                j += typeAmound[0];
            }
            if (j == 5) {
                type = Card.FIVE_OF_A_KIND;
                break;
            }
            if (j == 4) {
                type = Card.FOUR_OF_A_KIND;
                break;
            }
            if (j == 3) {
                if (type == Card.ONE_PAR) {
                    type = Card.FULL_HOUSE;
                } else {
                    type = Card.THREE_OF_A_KIND;
                }
                usedTypeAmount = true;
            }
            if (j == 2) {
                if (type == Card.ONE_PAR) {
                    type = Card.TWO_PAR;
                } else if (type == Card.THREE_OF_A_KIND) {
                    type = Card.FULL_HOUSE;
                } else {
                    type = Card.ONE_PAR;
                }
                usedTypeAmount = true;
            }
        }
    }

    @Override
    public int compareTo(Card o) {
        if (o.type != this.type) {
            return Integer.compare(o.type, this.type);
        }
        for (int i = 0; i < 5; i++) {
            if (o.hand[i] != this.hand[i]) {
                return Integer.compare(o.hand[i], this.hand[i]);
            }
        }
        return 0;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public long getScore() {
        return bid * rank;
    }
}
