package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    public static List<String> readInput(String inputFile) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get("workspace/src/inputFolder/" + inputFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> readInputLinux(String inputFile) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get("advent_of_code_2023/src/inputFolder/" + inputFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
