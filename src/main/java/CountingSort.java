import java.lang.reflect.Array;
import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(7);
        list.add(88);
        list.add(241);
        list.add(512);
        list.add(7);
        list.add(7);
        list.add(41256);
        list.add(-23);
        list.add(6);
        list.add(-77);
        list.add(9);

        System.out.println(Arrays.asList(countingSort(list)));
    }

    static List<Integer> countingSort(List<Integer> list) {
        List<Integer> secondList = new ArrayList(list.size());
        Map<Integer, Integer> mapOfValues = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (mapOfValues.containsKey(list.get(i))) {
                mapOfValues.put(list.get(i), mapOfValues.get(list.get(i)) + 1);
            } else {
                mapOfValues.put(list.get(i), 1);
            }
        }

        int minimum = list.get(0);
        int maximum = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (minimum > list.get(i)) {
                minimum = list.get(i);
            }
            if (maximum < list.get(i)) {
                maximum = list.get(i);
            }
        }

//        for (Map.Entry<Integer, Integer> entry : mapOfValues.entrySet()) {
//            for (int i = 0; i < entry.getValue(); i++) {
//                secondList.add(entry.getKey());
//            }
//        }
        int current = minimum;
        while (current <= maximum) {
            if (mapOfValues.containsKey(current)) {
                for (int i = 0; i < mapOfValues.get(current); i++) {
                    secondList.add(current);
                }
            }
            current++;
        }

        return secondList;

    }

}
