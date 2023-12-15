package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.InputUtil;

public class MirageMaintenance {

    public static void oasisReport(String inputFile) {
        Long sumPartOne = 0L;
        Long sumPartTwo = 0L;
        List<String> input = InputUtil.readInput(inputFile);

        for (String line : input) {
            int[] lineAsIntegers = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sumPartOne += findNextNumberInSequence(lineAsIntegers);
            sumPartTwo += findPreviousNumberInSequence(lineAsIntegers);
        }

        System.out.println("Solution Part One: " + sumPartOne);
        System.out.println("Solution Part Two: " + sumPartTwo);
    }

    private static int findNextNumberInSequence(int[] line) {
        List<Integer> lastNumbersOfSequence = new ArrayList<>();
        int[] lastNumbers = findSequence(line, lastNumbersOfSequence);
        int nextNumber = lastNumbers[lastNumbers.length - 1];
        for (int i = lastNumbers.length - 2; i >= 0; i--) {
            nextNumber += lastNumbers[i];
        }
        return line[line.length - 1] + nextNumber;
    }

    private static int findPreviousNumberInSequence(int[] line) {
        List<Integer> firstNumbersOfSequence = new ArrayList<>();
        int[] lastNumbers = findSequenceAddFirstNumber(line, firstNumbersOfSequence);
        int nextNumber = lastNumbers[lastNumbers.length - 1];
        for (int i = lastNumbers.length - 1; i >= 0; i--) {
            nextNumber = lastNumbers[i] - nextNumber;
        }
        return line[0] - nextNumber;
    }

    private static int[] findSequence(int[] seq, List<Integer> lastNumbers) {
        int[] newSeq = new int[seq.length - 1];
        for (int i = 0; i < seq.length - 1; i++) {
            newSeq[i] = seq[i + 1] - seq[i];
        }
        lastNumbers.add(newSeq[newSeq.length - 1]);
        if (!(newSeq[0] == 0 && newSeq[1] == 0)) {
            findSequence(newSeq, lastNumbers);
        }
        return lastNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int[] findSequenceAddFirstNumber(int[] seq, List<Integer> firstNumbers) {
        int[] newSeq = new int[seq.length - 1];
        for (int i = 0; i < seq.length - 1; i++) {
            newSeq[i] = seq[i + 1] - seq[i];
        }
        firstNumbers.add(newSeq[0]);
        if (!(newSeq[0] == 0 && newSeq[1] == 0)) {
            findSequenceAddFirstNumber(newSeq, firstNumbers);
        }
        return firstNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        oasisReport("day9.txt");
    }
}
