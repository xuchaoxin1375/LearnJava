package study.try_catch;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TryCatchMain {
    /*如果不想写任何try代码，可以直接把main()方法定义为throws Exception}{方法体写在里头}：
     * 区别于try..catch环绕处理:
     * 因为main()方法声明了可能抛出Exception，也就声明了可能抛出所有的Exception，
     * 因此在内部就无需捕获了。代价就是一旦发生异常，程序会立刻退出。*/
    public static void main(String[] args) throws Exception {
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
        byte[] bs2=toGBK2("中文");
        System.out.println(Arrays.toString(bs2));
    }

    /*定义一个要求捕获异常的方法:*/
    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        // 用指定编码转换String为byte[]:
        return s.getBytes("GBK");
    }
    /*定义一个在方法内部记录异常的方法*/
    //捕获后不处理的方式是非常不好的，即使真的什么也做不了，也要先把异常记录下来：
    static byte[] toGBK2(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 先记下来再说:
            e.printStackTrace();//所有异常都可以调用printStackTrace()方法打印异常栈，这是一个简单有用的快速打印异常的方法。
        }
        return null;
    }

}
