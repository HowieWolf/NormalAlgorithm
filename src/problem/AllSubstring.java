package problem;

import java.util.ArrayList;
import java.util.List;

public class AllSubstring {

    private String original = "";

    public List<String> allSubstring() {
        List<String> result = new ArrayList<>();
        int range = (int) Math.pow(2, original.length());
        for (int i = 0; i < range; i++) {
            String binaryString = toBinaryString(i);
            String sub = getSubstring(binaryString);
            result.add(sub);
        }
        return result;
    }

    /**
     * 十进制转任何进制
     * 使用除后取余法
     * @param index
     * @return
     */
    private String toBinaryString(int index) {
        StringBuilder builder = new StringBuilder();
        int shang = 0;
        int yushu = 0;
        do {
            shang = index / 2;
            yushu = index % 2;
            builder.insert(0, yushu);
            index = shang;
        } while (shang != 0);
        int less = original.length() - builder.length();
        for (int i = 0; i < less; i++) {
            builder.insert(0, '0');
        }
        return builder.toString();
    }

    private String getSubstring(String select) {
        if (select.length() != original.length()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < select.length(); i++) {
            if (select.charAt(i) == '1') {
                builder.append(original.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        AllSubstring test = new AllSubstring();
        test.original = "0123";
        List<String> result = test.allSubstring();
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
