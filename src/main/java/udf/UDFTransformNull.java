package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * 类名称:转换'null'、""为NULL
 * 类描述:Hive UDF函数
 * 创建人:roc
 * 创建时间:2020-10-28 10:00
 * 版本:v1.0
 */
public class UDFTransformNull extends UDF {
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

        return s;
    }
}
