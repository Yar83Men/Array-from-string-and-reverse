import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class StringToArray {
    public static void main(String args[]) {

        int[] testArr = {1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 9, 9, 9, 10, 11, 11, 11, 11, 11, 12, 12, 12,
                12, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 16, 16, 16, 17, 18, 17, 19, 16, 20, 20};
        System.out.println("String from test array");
        String delimitr = "-";
        System.out.println(serializeToString(testArr, delimitr));
        System.out.println("----------------------------------------------------------------------");

        String testString = serializeToString(testArr, delimitr);
        System.out.println("Array from test string");
        System.out.println(serializeToArray(testString, delimitr));
    }

    private static String serializeToString(int[] arr, String delimitr) {
        String s = "";
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);

            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        for (Integer key : map.keySet()) {

            s += Integer.toString(map.get(key)) + delimitr + Integer.toString(key) + ",";
        }

        s = s.substring(0, s.length() - 1);

        System.out.println(s.length() + " " + arr.length);
        return s;
    }

    private static ArrayList<Integer> serializeToArray(String str, String delimiter) {

        ArrayList<Integer> list = new ArrayList<>();

        String[] arr = str.split(",");

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {

            String[] temp = arr[i].split(delimiter);
            int count = Integer.parseInt(temp[0]);
            int num = Integer.parseInt(temp[1]);

            for (int k = 1; k <= count; k++) {
                list.add(num);
            }
        }
        // System.out.println(list);
        return list;
    }
}
