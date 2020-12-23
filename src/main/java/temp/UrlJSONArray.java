package temp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.util.ArrayList;

public class UrlJSONArray {
    public static void main(String[] args) {
        String s = "[{\"fileName\": \"03_901_lens_DSL.jpg\", \"fileUrl\": \"https://www.mouser.cn/images/eao/images/03_901_lens_DSL.jpg\"}]";

        JSONArray jsonArray = new JSONArray(s);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String fileUrl = jsonObject.getString("fileUrl").toLowerCase();
            if (fileUrl.endsWith("jpg") || fileUrl.endsWith("png")) {
                fileUrl = "\"" + fileUrl + "\"";
                result.add(fileUrl);
            }
        }

        System.out.println(result.toString());

        for (String res : result) {
            System.out.println(res);
        }
    }
}
