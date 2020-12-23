package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashMap;

/**
 * 类名称:UDFReplaceMoreSep
 * 类描述:多分隔符替换
 * 创建人:roc
 * 创建时间:2020/12/17 16:50
 * 版本:v1.0
 */
public class UDFReplaceMoreSep extends UDF {
    public String evaluate(String s) {
        if (s == null) {
            return null;
        }

        if (s.equals("")) {
            return null;
        }

        if (!s.contains("\",\"")) {
            return null;
        } else {
            s = s.split("\",\"")[1];
        }

        HashMap<String, String> sepHashMap = sepHashMap();
        for (String sep : sepHashMap.keySet()) {
            if (s.contains(sep)) {
                s = s.replace(sep, sepHashMap.get(sep));
            }
        }
        return s;
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
