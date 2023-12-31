package day15;

import java.util.ArrayList;
import java.util.List;

public class Box {
    List<String[]> labels = new ArrayList<>();
    private int index;

    public void removeLabel(String label) {
        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i)[0].equals(label)) {
                labels.remove(i);
                break;
            }
        }
    }

    public void addLabel(String label, String number) {
        String[] arr = {label, number};
        if (isInList(label)) {
            labels.set(index, arr);
        } else {
            labels.add(arr);
        }
    }

    private boolean isInList(String label) {
        index = 0;
        for (String[] strings : labels) {
            if (strings[0].equals(label)) {
                return true;
            }
            index++;
        }
        return false;
    }
}
