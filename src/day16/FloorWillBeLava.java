package day16;

import java.util.ArrayList;
import java.util.List;
import util.InputUtil;

public class FloorWillBeLava {

    public static void solution(String inputFile) {
        List<String> input = InputUtil.readInput(inputFile);
        long sum = 0;

        List<Beam> beams = new ArrayList<>();

        beams.add(new Beam(0, 0, Beam.EAST));

        for(Beam b : beams){
            handleSpot(b);
        }

        System.out.println("Solution Part One: " + sum);
    }

    private static void handleSpot(Beam b, List<String> lines) {
        String c = lines.get(b.getY()).substring(b.getX(), b.getX() + 1);
        if()
    }

    public static void main(String[] args) {
        solution("day16Example.txt");
    }
}
