package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public List<String> menuPoints = new ArrayList<String>();

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < menuPoints.size(); ++i) {
            result.append(Integer.toString(i) + ". " + menuPoints.get(i));
        }

        return result.toString();
    }
}
