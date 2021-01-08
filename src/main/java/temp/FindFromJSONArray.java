package temp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class FindFromJSONArray {
    public static void main(String[] args) {
        String jsonString = "[{\"property_name\": \"制造商\", \"property_value\": \"Kyocera\"}, {\"property_name\": \"产品种类\", \"property_value\": \"FFC & FPC连接器\"}, {\"property_name\": \"RoHS\", \"property_value\": \"Y\"}, {\"property_name\": \"产品\", \"property_value\": \"Connectors\"}, {\"property_name\": \"位置数量\", \"property_value\": \"7 Position\"}, {\"property_name\": \"节距\", \"property_value\": \"1 mm\"}, {\"property_name\": \"端接类型\", \"property_value\": \"Solder Pin\"}, {\"property_name\": \"安装角\", \"property_value\": \"Right Angle\"}, {\"property_name\": \"联系位置\", \"property_value\": \"Bottom Contact\"}, {\"property_name\": \"触点电镀\", \"property_value\": \"Tin\"}, {\"property_name\": \"电流额定值\", \"property_value\": \"1 A\"}, {\"property_name\": \"系列\", \"property_value\": \"6200\"}, {\"property_name\": \"最小工作温度\", \"property_value\": \"- 20 C\"}, {\"property_name\": \"最大工作温度\", \"property_value\": \"+ 85 C\"}, {\"property_name\": \"封装\", \"property_value\": \"Tray\"}, {\"property_name\": \"外壳材料\", \"property_value\": \"Thermoplastic (TP)\"}, {\"property_name\": \"电压额定值\", \"property_value\": \"50 V\"}, {\"property_name\": \"商标\", \"property_value\": \"Kyocera Electronic Components\"}, {\"property_name\": \"触点材料\", \"property_value\": \"Copper Alloy\"}, {\"property_name\": \"可燃性等级\", \"property_value\": \"UL 94 V-0\"}, {\"property_name\": \"安装风格\", \"property_value\": \"Through Hole\"}, {\"property_name\": \"驱动类型\", \"property_value\": \"ZIF\"}, {\"property_name\": \"外壳颜色\", \"property_value\": \"Black\"}, {\"property_name\": \"产品类型\", \"property_value\": \"FFC & FPC Connectors\"}, {\"property_name\": \"工厂包装数量\", \"property_value\": \"2600\"}, {\"property_name\": \"子类别\", \"property_value\": \"FFC & FPC Connectors\"}]\n";
        JSONArray extractObj = new JSONArray(jsonString);

        for (int i = 0; i < extractObj.length(); i++) {
            JSONObject jsonObject = extractObj.getJSONObject(i);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String s = keys.next();
                System.out.println(s);
            }
        }
    }
}
