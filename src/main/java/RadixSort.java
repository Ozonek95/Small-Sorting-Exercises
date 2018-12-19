import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(992, 42, 535,5893,125,7173,24,77);

        sort(list);
        System.out.println((Arrays.asList(list)));

    }


    static void sort(List<Integer> list) {

        List<List<Integer>> lists = new LinkedList<>();
        int devider = 1;
        for (int i=0;i<10;i++){
            lists.add(new LinkedList<>());
        }

        while (devider <= 10000) {
            for (Integer aList : list) {
                for (int j = 0; j < lists.size(); j++) {
                    if (aList / devider % 10 == j) {
                        lists.get(j).add(aList);
                    }
                }

            }
            int counterIndex = 0;
            for (List<Integer> list1 : lists) {
                if (list1.size() > 0) {
                    for (int j = 0; j < list1.size(); j++) {
                        list.set(counterIndex, list1.get(j));
                        counterIndex++;
                    }
                }
            }

            lists.forEach(List::clear);

            devider=devider*10;

        }
    }

}
