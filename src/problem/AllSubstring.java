package problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AllSubstring {

    public List<String> allSubstring(String origin) {
        List<String> result = new ArrayList<>();
        int range = (int) Math.pow(2, origin.length());
        for (int i = 0; i < range; i++) {
            String sub = getSubString(origin, i);
            result.add(sub);
        }
        return result;
    }

    /**
     * 使用位与运算可知每一位上是否是 0 或 1
     */
    private String getSubString(String origin, int select) {
        int len = origin.length();
        int flag = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if ((select & flag) > 0) {
                result.append(origin.charAt(i));
            }
            flag <<= 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AllSubstring test = new AllSubstring();
        List<String> result = test.allSubstring("0123");
        System.out.println(result.size());
        result.sort(Comparator.comparingInt(String::length));
        for (String s : result) {
            System.out.println(s);
        }
    }
}
