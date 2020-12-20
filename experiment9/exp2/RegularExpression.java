package experiment9.exp2;

/*拷贝Java源码文件如My.java至另一个文件中如My2.java，要求My2.java删除My.java的所有注释，其他完全相同。
//注：Java注释有两种，一种形如：/*……*/
//另一种形如 //…….
//*/

import experiment9.FileName;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class RegularExpression {
    /*创建缓冲流对象：它是过滤流，是对节点流的包装(也就是说,它依赖于节点流,需要基于FileReader/FileInputStream来包装使用.一般来说,推荐使用BufferedIO来操作文件比较好(比直接单纯使用FileIO来的方便和高效智能 */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(FileName.fileName3, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(FileName.fileNameOut2/*,StandardCharsets.UTF_8*/));//值得注意的是,在将内容写出的时候,是否默认(一般中文为gbk,还是要改为utf-8编码),在中,可以把末尾null都打印显示出来,不过在一般的记事本不会有这样的情况出现(大不了逐个字符读入呗)
        String string=null;

        char [] chars=new char[1000];
        StringBuffer stringBuffer=new StringBuffer();
        while(bufferedReader.read(chars)!=-1){
            stringBuffer.append(chars);
        }
        string=stringBuffer.toString();
        string=string.replaceAll("//", "").replaceAll("/\\*|\\*/","");

        //System.out.println(string);
        bufferedWriter.write(string);
        /*如下做法会引起换行失真*/
//       while( (string=bufferedReader.readLine())!=null){
//                string=string.replaceAll("//", "").replaceAll("/\\*|\\*/","");
//                                //值得注意的时,类似于强制类型转换一样,经过replaceAll方法处理的字符串本身不会发生改变,二十相当于处理源字符串的一个副本,并返回处理过的副本.
//           //  由于没有\*这一字符,所以你还需要将\\获得\,然后在加*,即\\*,这才代表regex中的普通字符串\*,而\*进一步被解释为'*'是普通字符而非元字符.
//                bufferedWriter.write(string+"\n");
//           System.out.println(string);
//       }


        bufferedWriter.flush();  //step2:刷新缓冲区
        //step3:释放资源:
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("操作完毕.");
           /*
A String containing the contents of the line, not including any line-termination characters,
 or null if the end of the stream has been reached without reading any characters*/

    }
}