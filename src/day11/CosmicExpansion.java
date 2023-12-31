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
        List<Integer> rowsWithoutGalaxies = new ArrayList<>();
        List<Integer> columnsWithoutGalaxies = new ArrayList<>();

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
//            newInput.add(index, line);
            if (!hasGalaxy) {
//                newInput.add(index + 1, ".".repeat(line.length()));
//                index++;
                rowsWithoutGalaxies.add(index);
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
//                addColumn(newInput, i + tmp);
//                tmp++;
                columnsWithoutGalaxies.add(i);
            }
        }

        int y = 0;
        int number = 1;
        for (String line : input) {
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
                int difX;
                int x;
                if (galaxy.getX() > galaxies.get(i).getX()) {
                    difX = galaxy.getX() - galaxies.get(i).getX();
                    x = timesContainsInList(rowsWithoutGalaxies, galaxies.get(i).getX(), galaxy.getX());
                } else {
                    difX = galaxies.get(i).getX() - galaxy.getX();
                    x = timesContainsInList(rowsWithoutGalaxies, galaxy.getX(), galaxies.get(i).getX());
                }

                int difY;
                int y2;
                if (galaxy.getY() > galaxies.get(i).getY()) {
                    difY = galaxy.getY() - galaxies.get(i).getY();
                    y2 = timesContainsInList(columnsWithoutGalaxies, galaxies.get(i).getY(), galaxy.getY());
                } else {
                    difY = galaxies.get(i).getY() - galaxy.getY();
                    y2= timesContainsInList(columnsWithoutGalaxies, galaxy.getY(), galaxies.get(i).getY());
                }
                val += difX + (1000000 * (x == 0 ? x : x - 1)) + difY + (1000000 * (y2 == 0 ? 0 : y2 - 1));
            }
        }


        System.out.println("Solution: " + (val / 2));
    }

    private static int timesContainsInList(List<Integer> list, int start, int end) {
        int count = 0;

        for (int i = start; i <= end; i++) {
            if (list.contains(i)) {
                count++;
            }
        }

        return count;
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

        // 379923889949
        // 184118269864
        // 230532269864

    }
}
