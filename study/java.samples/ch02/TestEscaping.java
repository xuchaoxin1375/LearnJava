/* 测试反转义字符: */
public class TestEscaping {

    private TestEscaping() {
        System.out.println("constructor has been called!");
    }

    public static void main(String[] args) {

        /*
         * System.out.print("test "); System.out.println(57);//打印数字57;
         * System.out.print('t');// 打印字符t;
         * System.out.println((int)('0'));//打印字符的ASCII码:强制转换为int类型;这个语句打印48;
         * 
         * System.out.println(t);//不能够随意打印表示符(包括单个字母;因为打印语句会认为这个标识符表示某个变量,但是如果你没有定义该变量,
         * 就会出错;) System.out.println('\'');//打印:' System.out.print('\t');//打印出一个4个空格;
         * System.out.println("test\ttest");//在字符串中转义\t;打印:test test
         * System.out.println('\t'+'\'');//输出48;
         */

        /*
         * char c = 'c';// ascii=99 int num = 10; String str = "Java";
         * System.out.println(c + num + str); System.out.println(c + (num + str));
         * System.out.println(c + str + num); System.out.println(str + num + c);
         * System.out.println(1+1);//2
         */
        /*输出结果分别:
         * 109Java 
         * c10Java 
         * cJava10 
         * Java10c
         */
        /*
         * System.out.println("'\t'");//结果:' '; System.out.println("''");//结果:''
         */
        // 事实上,println是被重载了的(分别对应形参类型是char x/int x/String x/)
        // System.out.println("* *");
        // System.out.println('*');//*;该函数调用的是参数char 类型的println()
        // System.out.println((int)'*');//42
        // System.out.println((int)'\t');//9

        // System.out.println('*'+'\t'+'*'); //结果是93;comment out 添加注释

        // System.out.println('*'+"\t"+'*'); //* *;其过程为,'*'遇到字符串"\t"会升级为"*"字符串,
        // System.out.println('*'+'\t'+"*");//51*.
        /*
         * 其中,char+char会引发自动类型转换,即会同时升级为int类型.在再做运算(+)
         *其实: Byte、short、char之间不会相互转换，他们三者在计算时首先转换为int类型。然后在做运算
         */
        // System.out.println('*'+('\t'+"*"));//* *
        /*
         * System.out.print((char)48);//打印字符0
         * System.out.print((char)0);//空字符(打印一个空格)
         * System.out.println((char)48);
         */

        System.out.println('*' + '\t' + '*');
    }
}
/*
 * 字符(char)直接量(常用的转义字符) • '\b' (退格) • '\f' (换页) • '\n' (换行) • '\r' (回车) • '\t'
 * (水平制表符(到下一个tab位置)) • '\' ' (单引号) • '\" ' (双引号) • '\\' (反斜杠)
 */