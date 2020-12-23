package udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 类名称:UDFUrlJSONArray
 * 类描述:自定义函数解析JSONArray
 * 创建人:roc
 * 创建时间:2020/11/10 17:48
 * 版本:v1.0
 */
public class UDFUrlJSONArray extends UDF {
    public String evaluate(String JSONString) {
        //判断JSONString是否为null
        if (JSONString == null) {
            return null;
        }

        //判断JSONString是否为空字符串
        if (JSONString.equals("")) {
            return null;
        }

        try {
            JSONArray extractObj = new JSONArray(JSONString);
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < extractObj.length(); i++) {
                JSONObject jsonObject = (JSONObject) extractObj.get(i);
                String fileUrl = jsonObject.getString("fileUrl").toLowerCase();
                if (fileUrl.endsWith("jpg") || fileUrl.endsWith("png")) {
                    fileUrl = "\"" + fileUrl + "\"";
                    result.add(fileUrl);
                }
            }
            return result.toString();
        } catch (JSONException e) {
            System.out.println("JSON字符串格式错误！");
            return null;
        } catch (NumberFormatException e) {
            return null;
        }

    }
}
