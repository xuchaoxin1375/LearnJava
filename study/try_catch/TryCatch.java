package study.try_catch;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TryCatch {
    public static void main(String[] args) {
        byte[] bs = toGBK("中文");
  /*Object类当中包含的方法有11个。主要学习其中的2个：
- public String toString()：返回该对象的字符串表示。
- public boolean equals(Object obj)：指示其他某个对
象是否与此对象“相等”。*/
        System.out.println(Arrays.toString(bs));
    }

    static byte[] toGBK(String s) {
        /*在方法中嵌入try..catch机制捕捉异常;*/
        try {
            // 用指定编码转换String为byte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
            System.out.println(e); // 打印异常信息
            /*改变处理方式在尝试*/
            return s.getBytes(); // 尝试使用用默认编码
        }
    }
}

