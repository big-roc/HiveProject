package temp;

/**
 * 类名称:Temp
 * 类描述:一句话描述该类的功能
 * 创建人:roc
 * 创建时间:2020/11/16 17:33
 * 版本:v1.0
 */
public class FindMoreSep {
    public static void main(String[] args) {
        //String s = "长度“*”高度“*”高度";
        //String sep1 = "“\\*”";
        //findSep(s, sep1);

        String s = "长度“*”宽度“*”高度";
        String sep2 = "“\\*”";
        splitMore(s, sep2);
    }

    private static void findSep(String s, String sep1) {
        if (s.contains(sep1)) {
            System.out.println("包含*");
        }
    }

    private static void splitMore(String s, String sep) {
        String[] arrayString = s.split(sep);
        for (String w : arrayString) {
            System.out.println(w);
        }
    }
}
