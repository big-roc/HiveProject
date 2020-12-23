package temp;

import java.util.HashMap;

public class ReplaceMoreSep {
    public static void main(String[] args) {
        String s = "\"传感器，变送器\",\"光学传感器 -xa0光电晶体管\"";
        evaluate(s);
    }

    public static void evaluate(String s) {

        s = s.split("\",\"")[1];

        HashMap<String, String> sepHashMap = sepHashMap();
        for (String sep : sepHashMap.keySet()) {
            if (s.contains(sep)) {
                s = s.replace(sep, sepHashMap.get(sep));
            }
        }
        System.out.println(s);
    }

    // 设置一个HashMap，存放需要替换的分隔符
    private static HashMap<String, String> sepHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(" ", "");
        hashMap.put("\"", "");
        hashMap.put("，", ",");
        hashMap.put("（", "(");
        hashMap.put("）", ")");
        hashMap.put("xa0", "");
        hashMap.put("、", ",");
        return hashMap;
    }
}
