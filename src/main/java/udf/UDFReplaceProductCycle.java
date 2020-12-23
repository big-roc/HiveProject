package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashMap;

/**
 * 类名称:UDFReplaceProductCycle
 * 类描述:标准化是否停产字段
 * 创建人:roc
 * 创建时间:2020/12/17 16:50
 * 版本:v1.0
 */
public class UDFReplaceProductCycle extends UDF {
    public String evaluate(String s) {
        if (s == null) {
            return null;
        }

        if (s.equals("")) {
            return null;
        }

        if (s.equals("null")) {
            return null;
        }

        s = s.replaceAll("\\s*", "");

        HashMap<String, String> sepHashMap = sepHashMap();
        for (String productCycle : sepHashMap.keySet()) {
            if (s.equals(productCycle)) {
                s = sepHashMap.get(productCycle);
            }
        }
        return s;
    }

    // 设置一个HashMap，存放需要标准化的字符串
    private static HashMap<String, String> sepHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("寿命结束:将过时且制造商将停产。", "是");
        hashMap.put("新技术:用于最新设计的尖端技术。", "否");
        hashMap.put("Mouser的新产品", "否");
        hashMap.put("与工厂核实状态:寿命周期信息不详。获取报价以从制造商那里核实此零件编号的供货情况。", "否");
        hashMap.put("NRND:不建议用于新设计。", "即将停产");
        hashMap.put("零件编号更改:仅零件编号修订版。制造商已更改此零件编号。这是之前的零件编号。", "否");
        hashMap.put("工厂特别订单:获取报价以核实当前价格、交货期和制造商的订购要求。", "受限供货");
        hashMap.put("初次公布:提供的数量有限。规格可能更改，恕不另行通知。", "受限供货");
        hashMap.put("即将发布", "否");
        hashMap.put("新产品:此制造商的新产品。", "否");
        hashMap.put("作废", "是");
        hashMap.put("受限供货情况:Mouser当前不供应此零件编号的零件。产品可能为限量销售或工厂特别订单。", "受限供货");
        return hashMap;
    }
}
