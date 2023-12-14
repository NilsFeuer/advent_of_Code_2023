package day5;

import util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class PartOne {

    public static String exampleInput = """
            seeds: 79 14 55 13
                        
            seed-to-soil map:
            50 98 2
            52 50 48
                        
            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15
                        
            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4
                        
            water-to-light map:
            88 18 7
            18 25 70
                        
            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13
                        
            temperature-to-humidity map:
            0 69 1
            1 0 69
                        
            humidity-to-location map:
            60 56 37
            56 93 4
            """;


    public static Long lowestLocation(String inputFile) {
        List<String> input = InputUtil.readInput(inputFile);

        List<Long> seeds = new ArrayList<>();
        List<List<Long>> seedToSoil = new ArrayList<>();
        List<List<Long>> soilToFertilizer = new ArrayList<>();
        List<List<Long>> fertilizerToWater = new ArrayList<>();
        List<List<Long>> waterToLight = new ArrayList<>();
        List<List<Long>> lightToTemperature = new ArrayList<>();
        List<List<Long>> temperatureToHumidity = new ArrayList<>();
        List<List<Long>> humidityToLocation = new ArrayList<>();

        Long location = Long.MAX_VALUE;

        //get Seeds
        int length = 0;
        for (int j = 7; j < input.get(0).length(); j++) {
            if (Character.isDigit(input.get(0).charAt(j))) {
                length++;
            }
            if (input.get(0).charAt(j) == ' ' || j == input.get(0).length() - 1) {
                if (j == input.get(0).length() - 1) {
                    seeds.add(Long.parseLong(input.get(0).substring(j - length + 1, j + 1)));
                } else {
                    seeds.add(Long.parseLong(input.get(0).substring((j - length), j)));
                }
                length = 0;
            }
        }

        int index = 3;
        index = fillLists(seedToSoil, input, index);
        index = fillLists(soilToFertilizer, input, index);
        index = fillLists(fertilizerToWater, input, index);
        index = fillLists(waterToLight, input, index);
        index = fillLists(lightToTemperature, input, index);
        index = fillLists(temperatureToHumidity, input, index);
        fillLists(humidityToLocation, input, index);

        for (Long seed : seeds) {
            seed = transform(seedToSoil, seed);
            seed = transform(soilToFertilizer, seed);
            seed = transform(fertilizerToWater, seed);
            seed = transform(waterToLight, seed);
            seed = transform(lightToTemperature, seed);
            seed = transform(temperatureToHumidity, seed);
            location = Math.min(location, transform(humidityToLocation, seed));
        }

        return location;
    }

    public static Long lowestLocationPartTwo(String inputFile) {
        List<String> input = InputUtil.readInput(inputFile);

        List<List<Long>> seedToSoil = new ArrayList<>();
        List<List<Long>> soilToFertilizer = new ArrayList<>();
        List<List<Long>> fertilizerToWater = new ArrayList<>();
        List<List<Long>> waterToLight = new ArrayList<>();
        List<List<Long>> lightToTemperature = new ArrayList<>();
        List<List<Long>> temperatureToHumidity = new ArrayList<>();
        List<List<Long>> humidityToLocation = new ArrayList<>();

        List<List<Long>> seedRanges = new ArrayList<>();
        Long location = Long.MAX_VALUE;

        //get Seeds
        int length = 0;
        List<Long> seeds = new ArrayList<>();
        for (int j = 7; j < input.get(0).length(); j++) {
            if (Character.isDigit(input.get(0).charAt(j))) {
                length++;
            }
            if (input.get(0).charAt(j) == ' ' || j == input.get(0).length() - 1) {
                if (j == input.get(0).length() - 1) {
                    seeds.add(Long.parseLong(input.get(0).substring(j - length + 1, j + 1)));
                } else {
                    seeds.add(Long.parseLong(input.get(0).substring((j - length), j)));
                }
                length = 0;
            }
            if (seeds.size() == 2) {
                seedRanges.add(seeds);
                seeds = new ArrayList<>();
            }
        }

        int index = 3;
        index = fillLists(seedToSoil, input, index);
        index = fillLists(soilToFertilizer, input, index);
        index = fillLists(fertilizerToWater, input, index);
        index = fillLists(waterToLight, input, index);
        index = fillLists(lightToTemperature, input, index);
        index = fillLists(temperatureToHumidity, input, index);
        fillLists(humidityToLocation, input, index);

        for (List<Long> seedRange : seedRanges) {
            for (int i = 0; i < seedRange.get(1); i++) {
                Long seed = seedRange.get(0) + i;
                seed = transform(seedToSoil, seed);
                seed = transform(soilToFertilizer, seed);
                seed = transform(fertilizerToWater, seed);
                seed = transform(waterToLight, seed);
                seed = transform(lightToTemperature, seed);
                seed = transform(temperatureToHumidity, seed);
                location = Math.min(location, transform(humidityToLocation, seed));
            }
        }

        return location;
    }

    private static int fillLists(List<List<Long>> sourceToDest, List<String> input, int index) {
        int length = 0;
        for (int i = index; i < input.size(); i++) {
            List<Long> numbers = new ArrayList<>();
            if (input.get(i).isEmpty()) {
                index = i + 2;
                break;
            }
            for (int j = 0; j < input.get(i).length(); j++) {
                if (Character.isDigit(input.get(i).charAt(j))) {
                    length++;
                }
                if (input.get(i).charAt(j) == ' ' || j == input.get(i).length() - 1) {
                    if (j == input.get(i).length() - 1) {
                        numbers.add(Long.parseLong(input.get(i).substring((j - length + 1), j + 1)));
                    } else {
                        numbers.add(Long.parseLong(input.get(i).substring(j - length, j)));
                    }
                    length = 0;
                }
            }
            sourceToDest.add(numbers);
        }
        return index;
    }

    private static long transform(List<List<Long>> rules, long seed) {
        for (List<Long> rule : rules) {
            long destinationRangeStart = rule.get(0);
            long sourceRangeStart = rule.get(1);
            long range = rule.get(2);

            if (isWithInRange(seed, sourceRangeStart, sourceRangeStart + range)) {
                return (seed - sourceRangeStart) + destinationRangeStart;
            }
        }
        return seed;
    }

    private static boolean isWithInRange(long number, long lowerBound, long upperBound) {
        return number >= lowerBound && number < upperBound;
    }

    public static void main(String[] args) {
        System.out.println("Solution Part 1: " + lowestLocation("day5.txt"));
//        System.out.println("Solution Part 2: " + lowestLocationPartTwo("day5.txt"));
    }
}
