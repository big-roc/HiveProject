package udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 类名称:UDFSpecObject
 * 类描述:处理spec_object字段
 * 创建人:roc
 * 创建时间:2020/11/10 17:48
 * 版本:v1.0
 */
public class UDFSpecObject extends UDF {
    public String evaluate(String s) {
        if (s == null) {
            return "";
        }

        if (s.equals("")) {
            return "";
        }
        try {
            ArrayList<String> result = new ArrayList<>();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fileName", "数据手册");
            jsonObject.put("fileType", 20);
            jsonObject.put("fileUrl", s);
            result.add(jsonObject.toString());
            return result.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
