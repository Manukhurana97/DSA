package OldCode.Sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortByFrequency {

    static void sort(List<Integer> arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr.get(i)))
                map.replace(arr.get(i), map.get(arr.get(i) + 1));
            else
                map.put(arr.get(i), 1);
        }

        Collections.sort(arr, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                int f1 = map.get(o1);
                int f2 = map.get(o2);

                if(f1!=f2) return f2-f1;
                return arr.indexOf(f1)-arr.indexOf(f2);
            }
        });
    }

    public static void main(String[] args) {

    }
}
