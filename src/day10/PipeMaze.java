package day10;

import java.io.IOException;
import java.util.List;
import util.InputUtil;

public class PipeMaze {

    private static String NORTH_SOUTH = "|";
    private static String EAST_WEST = "-";
    private static String NORTH_EAST = "L";
    private static String NORTH_WEST = "J";
    private static String SOUTH_WEST = "7";
    private static String SOUTH_EAST = "F";
    private static String GROUND = ".";
    private static String START = "S";
    static int SIZE = 140;


    public static void solution(String inputFile) {

        List<String> input = InputUtil.readInput(inputFile);


        String[] map = new String[SIZE * SIZE];

        long val = 0;
        int x = 0;
        int y = 0;

        boolean[] visit = new boolean[SIZE * SIZE];

        int startX = 0;
        int startY = 0;

        for (String line : input) {
            if (line.isBlank()) {
                continue;
            }
            x = 0;
            for (String c : line.split("")) {
                map[y * SIZE + x] = c;
                if (c.equals(START)) {
                    startX = x;
                    startY = y;
                }
                x++;
            }
            y++;
        }

     /*   Position northP = new Position(startX, startY);
        northP.move(Position.NORTH);
        while (northP.isCanMove()) {
            northP = loopLength(northP, visit, map);
        }*/
        Position southP = new Position(startX, startY);
        southP.move(Position.SOUTH);
        while (southP.isCanMove()) {
            southP = loopLength(southP, visit, map);
        }
      /*  Position westP = new Position(startX, startY);
        westP.move(Position.WEST);
        while (westP.isCanMove()) {
            westP = loopLength(westP, visit, map);
        }
        Position eastP = new Position(startX, startY);
        eastP.move(Position.EAST);
        while (eastP.isCanMove()) {
            eastP = loopLength(eastP, visit, map);
        }*/

        visit[startY * SIZE + startX] = true;

//        System.out.println(northP.getCount());
        System.out.println(southP.getCount());
//        System.out.println(westP.getCount());
        try {
            System.out.println(southP.getArea(visit));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(eastP.getCount());
    }

    private static Position loopLength(Position p, boolean[] visit, String[] map) {
        int startY = p.getY();
        int startX = p.getX();
        int dir = p.getDirection();

        if (dir == Position.NORTH) {
            String tile = map[startY * SIZE + startX];
            if (tile.equals(NORTH_SOUTH) && !visit[(startY + 1) * SIZE + startX]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.NORTH);
                return p;
            }
            if (tile.equals(NORTH_EAST) && !visit[startY * SIZE + startX + 1]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.EAST);
                return p;
            }
            if (tile.equals(NORTH_WEST) && !visit[startY * SIZE + startX - 1]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.WEST);
                return p;
            }
        }

        if (dir == Position.SOUTH) {
            String tile = map[startY * SIZE + startX];
            if (tile.equals(NORTH_SOUTH) && !visit[(startY - 1) * SIZE + startX]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.SOUTH);
                return p;
            }
            if (tile.equals(SOUTH_EAST) && !visit[startY * SIZE + startX + 1]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.EAST);
                return p;
            }
            if (tile.equals(SOUTH_WEST) && !visit[startY * SIZE + startX - 1]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.WEST);
                return p;
            }
        }

        if (dir == Position.WEST) {
            String tile = map[startY * SIZE + startX];
            if (tile.equals(NORTH_EAST) && !visit[(startY - 1) * SIZE + startX]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.SOUTH);
                return p;
            }
            if (tile.equals(SOUTH_EAST) && !visit[(startY + 1) * SIZE + startX]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.NORTH);
                return p;
            }
            if (tile.equals(EAST_WEST) && !visit[startY * SIZE + startX - 1]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.WEST);
                return p;
            }
        }

        if (dir == Position.EAST) {
            String tile = map[startY * SIZE + startX];
            if (tile.equals(NORTH_WEST) && !visit[(startY - 1) * SIZE + startX]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.SOUTH);
                return p;
            }
            if (tile.equals(SOUTH_WEST) && !visit[(startY + 1) * SIZE + startX]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.NORTH);
                return p;
            }
            if (tile.equals(EAST_WEST) && !visit[startY * SIZE + startX + 1]) {
                visit[startY * SIZE + startX] = true;
                p.move(Position.EAST);
                return p;
            }
        }

        p.setCanMove(false);
        return p;
    }

    public static void main(String[] args) {
        solution("day10.txt");
    }
}
