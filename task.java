package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class func {
    public static void findDiff(String[] first, String[] second) {
        Map<String, Integer> count = new HashMap<>();

        ArrayList<String> Removed = new ArrayList<>();
        ArrayList<String> Added = new ArrayList<>();

        for (String value : first) {
            int current = count.getOrDefault(value, 0);
            count.put(value, current - 1);
        }
        for (String value : second) {
            int current = count.getOrDefault(value, 0);
            count.put(value, current + 1);
        }

        for (Map.Entry<String, Integer> it : count.entrySet()) {
            String key = it.getKey();
            Integer value = it.getValue();

            if (value > 0)
                for (int i = 0; i < Math.abs(value); i++){
                    Added.add(key);
                }

            if (value < 0)
                for (int i = 0; i < Math.abs(value); i++){
                    Removed.add(key);
                }

        }
        System.out.println("Added: " + Added);
        System.out.println("Removed: " + Removed);

    }

    public static void main(String[] args) {

        String[] first = new String[]  {"csharp", "test", "interview", "test"};
        String[] second = new String[] {"csharp", "test", "offer", "test", "test","test", "test", "test","test"};

        System.out.println("Result");

        findDiff(first,second);

    }
}


