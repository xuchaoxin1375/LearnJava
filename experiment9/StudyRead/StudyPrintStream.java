package experiment9.StudyRead;

import namesAndStrings.FileName;

import java.io.*;

public class StudyPrintStream {

    public static void main(String[] args) throws FileNotFoundException {
//������д
        System.out.println("Hello World");
//�ֿ���д
        PrintStream ps = System.out;//֮ǰ������ö�������ǲ������ⲿʹ��ʱnew��
        /*��һ��ģʽ�������������󣬾���ֻ��һ����������ʵ�����Ѿ�������new�õģ�
        public static�Ķ��ҹ������Ѿ���private����;Ҳ���Ǻ�enum���������Ƶ��ַ�(���췽����������,����Ҫnew,Ҫnew�Ļ��Ǿ��ǵ���������ʽ(���صĹ��캯����);
        ��֮,Ĭ�ϵ�out������System��һ�������Ա(PrintStream���͵�(����)����.)
        */
        /*��System����,��Ա����out:  public static final PrintStream out = null;*/
        /*PrintStream extends FilterOutputStream;
        * FilterOutputStream extends OutputStream*/
        //PrintStream��Ķ�����println����
        ps.println("hello printStream");
        ps.println("hello system");
// ��׼���������ָ�����̨��ָ��log���ļ�
        PrintStream printStream = new PrintStream(new FileOutputStream(FileName.prefix3 +"log.txt"));//�����õĹ��췽��:public PrintStream(@NotNull java.io.OutputStream out)
// �޸�������򣬽�����ĵ�log�ļ�
        System.setOut(printStream);
// ���
        System.out.println("hello word");
        System.out.println("hello System");
        System.out.println("hello PrintStream");
        System.out.println("hello InputStream");
        System.out.println("hello OutputStream");
    }

}
