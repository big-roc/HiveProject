package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;

/**
 * 类名称:UDFConcatHTTPS
 * 类描述:拼接https:
 * 创建人:roc
 * 创建时间:2020-10-28 10:00
 * 版本:v1.0
 */
public class UDFConcatHTTPS extends UDF {
    public String evaluate(String s) {
        if (s == null) {
            return null;
        }

        if (s.equals("")) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String res = "\"https:" + s + "\"";
        arrayList.add(res);
        return arrayList.toString();
    }
}
