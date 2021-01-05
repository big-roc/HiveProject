package udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 类名称:UDFConcatJSONArray
 * 类描述:拼接JSONArray和String
 * 创建人:roc
 * 创建时间:2020/11/10 17:48
 * 版本:v1.0
 */
public class UDFConcatJSONArray extends UDF {
    public String evaluate(String JSONString, String param, String brand) {
        //判断param是否为null
        if (JSONString == null) {
            return null;
        }

        if (JSONString.equals("")) {
            return null;
        }

        try {
            JSONArray jsonArray = new JSONArray(JSONString);
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                result.add(jsonArray.get(i).toString());
            }

            //把封装处理成JSON格式，添加到属性中
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("property_name", "封装 / 箱体");
            jsonObject.put("property_value", param);
            result.add(jsonObject.toString());

            //把品牌处理成JSON格式，添加到属性中
            JSONObject jsonBrand = new JSONObject();
            jsonBrand.put("property_name", "品牌");
            jsonBrand.put("property_value", brand);
            result.add(jsonBrand.toString());
            return result.toString();
        } catch (JSONException e) {
            System.out.println("JSON字符串格式错误！");
            return null;
        }
    }
}
