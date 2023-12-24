package day11;

import java.util.ArrayList;
import java.util.List;
import util.InputUtil;

public class CosmicExpansion {

    private String example = """
            ...#......
            .......#..
            #.........
            ..........
            ......#...
            .#........
            .........#
            ..........
            .......#..
            #...#.....
            """;

    public static void paths(String inputFile) {
        long val = 0;

        List<String> input = InputUtil.readInput(inputFile);
        List<String> newInput = new ArrayList<>();
        List<Galaxy> galaxies = new ArrayList<>();

        // find rows without galaxies
        int index = 0;
        for (String line : input) {
            boolean hasGalaxy = false;
            for (String s : line.split("")) {
                if (s.equals("#")) {
                    hasGalaxy = true;
                    break;
                }
            }
            newInput.add(index, line);
            if (!hasGalaxy) {
                newInput.add(index + 1, ".".repeat(line.length()));
                index++;
            }
            index++;
        }

        // find columns without galaxies
        int tmp = 0;
        for (int i = 0; i < input.get(0).length(); i++) {
            boolean hasGalaxy = false;
            for (String s : input) {
                if (s.charAt(i) == '#') {
                    hasGalaxy = true;
                    break;
                }
            }
            if (!hasGalaxy) {
                addColumn(newInput, i + tmp);
                tmp++;
            }
        }

        int y = 0;
        int number = 1;
        for (String line : newInput) {
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    galaxies.add(new Galaxy(number, x, y));
                    number++;
                }
            }
            y++;
        }

        for (Galaxy galaxy : galaxies) {
            for (int i = 0; i < galaxies.size(); i++) {
                if (galaxy.equals(galaxies.get(i))) {
                    continue;
                }
                val += galaxy.getX() > galaxies.get(i).getX() ? galaxy.getX() - galaxies.get(i).getX() : galaxies.get(i).getX() - galaxy.getX();
                val += galaxy.getY() > galaxies.get(i).getY() ? galaxy.getY() - galaxies.get(i).getY() : galaxies.get(i).getY() - galaxy.getY();
            }
        }


        System.out.println("Solution: " + (val / 2));
    }

    private static void addColumn(List<String> input, int index) {
        int i = 0;
        for (String line : input) {
            StringBuilder stringBuilder = new StringBuilder(line);
            stringBuilder.insert(index, ".");
            input.set(i, stringBuilder.toString());
            i++;
        }
    }

    public static void main(String[] args) {
        paths("day11.txt");
    }
}
