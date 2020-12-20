package experiment9.StudyRead;

import namesAndStrings.FileName;

import java.io.*;

public class StudyPrintStream {

    public static void main(String[] args) throws FileNotFoundException {
//合起来写
        System.out.println("Hello World");
//分开来写
        PrintStream ps = System.out;//之前遇到的枚举类型是不用在外部使用时new的
        /*有一种模式叫做，单例对象，就是只有一个单例对象实例是已经在类里new好的，
        public static的而且构造器已经被private隐藏;也就是和enum对象是类似的手法(构造方法都被隐藏,不需要new,要new的话是就是调用另外形式(重载的构造函数了);
        总之,默认的out对象是System的一个对象成员(PrintStream类型的(单例)对象.)
        */
        /*在System类中,成员对象out:  public static final PrintStream out = null;*/
        /*PrintStream extends FilterOutputStream;
        * FilterOutputStream extends OutputStream*/
        //PrintStream类的对象有println方法
        ps.println("hello printStream");
        ps.println("hello system");
// 标准输出流不再指向控制台，指向“log”文件
        PrintStream printStream = new PrintStream(new FileOutputStream(FileName.prefix3 +"log.txt"));//这里用的构造方法:public PrintStream(@NotNull java.io.OutputStream out)
// 修改输出方向，将输出改到log文件
        System.setOut(printStream);
// 输出
        System.out.println("hello word");
        System.out.println("hello System");
        System.out.println("hello PrintStream");
        System.out.println("hello InputStream");
        System.out.println("hello OutputStream");
    }

}
