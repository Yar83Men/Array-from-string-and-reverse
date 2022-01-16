import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class StringToArray {
    public static void main(String args[]) {

        int[] testArr = { 1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 9, 9, 9, 10, 11, 11, 11, 11, 11, 12, 12, 12, 12,
                13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 16 };
        System.out.println("String from test array");
        System.out.println(serializeToString(testArr));
        System.out.println("----------------------------------------------------------------------");

        String testString = "2x1,3x2,1x3,1x4,3x5,3x6,3x7,3x9,1x10,5x11,4x12,5x13,2x14,3x15,1x16,";
        System.out.println("Array from test string");
        System.out.println(serializeToArray(testString));
    }

    private static String serializeToString(int[] arr) {
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

            s += Integer.toString(map.get(key)) + "x" + Integer.toString(key) + ",";
        }
        s = s.substring(0, s.length() - 1);
        // System.out.println(s + " " + s.length() + " " + arr.length + " " +
        // map.size());
        return s;
    }

    private static ArrayList<Integer> serializeToArray(String str) {

        ArrayList<Integer> list = new ArrayList<>();

        String[] arr = str.split(",");

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {

            String[] temp = arr[i].split("x");
            int count = Integer.parseInt(temp[0]);
            int num = Integer.parseInt(temp[1]);

            for (int k = 1; k <= count; k++) {
                list.add(num);
            }
        }
        //System.out.println(list);
        return list;
    }

}
