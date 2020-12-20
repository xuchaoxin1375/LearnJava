package study.try_catch;
//如果我们不捕获UnsupportedEncodingException，会出现编译失败的问题：
// try...catch
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CatchNecessary {
    public static void main(String[] args) {
        try {
            byte[] bs = toGBK("中文");/* static byte[] toGBK(@NotNull String s) throws UnsupportedEncodingException*/
            System.out.println("try succeed!\n"+Arrays.toString(bs));
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            System.out.println("遗憾try没成功.");
            System.out.println(e);
        }
    }
    /*   static byte[] toGBK(String s) {
            return s.getBytes("GBK");
        }
        其中java.lang.String @NotNull
    @Contract(pure = true)
    public byte[] getBytes(@NonNls @NotNull String charsetName) throws java.io.UnsupportedEncodingException
        */
            /*         编译器会报错，错误信息类似：unreported exception UnsupportedEncodingException;
            must be caught or declared to be thrown，并且准确地指出需要捕获的语句是return s.getBytes("GBK");。
            意思是说，像UnsupportedEncodingException这样的Checked Exception，必须被捕获。
                     这是因为String.getBytes(String)方法定义是：
            public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
                    ...
                    }*/
    /*toGBK()是我们自己定义的声明了throws UnsupportedEncodingException要求的方法,在调用的时候必须添加try...catch环绕(预期可以正常执行的那一部分(方法调用)放在try中,异常处理放在catch中*/
    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");/*public byte[] getBytes(@NonNls @NotNull String charsetName) throws java.io.UnsupportedEncodingException*/
    }
}
/*因为在main()方法中，调用toGBK()，没有捕获它声明的可能抛出的UnsupportedEncodingException。
修复方法是在main()方法中捕获异常并处理：*/

/*在 方法定义的时候，使用throws Xxx表示该方法可能抛出的异常类型。
相应的,在调用这种带throws的方法的时候，必须强制捕获这些异常，否则编译器会报错。*/

/*可见，只要是方法声明的Checked Exception，不在调用层捕获，
也必须在更高的调用层捕获。所有未捕获的异常，最终也必须在main()方法中捕获，不会出现漏写try的情况。这是由编译器保证的。main()方法也是最后捕获Exception的机会。
    如果不想写任何try代码，可以直接把main()方法定义为throws Exception：
    因为main()方法声明了可能抛出Exception，也就声明了可能抛出所有的Exception，因此在内部就无需捕获了。
    代价就是一旦发生异常，程序会立刻退出。*/