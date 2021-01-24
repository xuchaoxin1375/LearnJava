package acmInJava.breakACode;

/**
 * 苏军知道德军用的加密方法是这样的：
 * 1.获得一段文字后，求出它的长度(包括空格)len。
 * 2.进入加密运算的第1步:把所有下标是1倍数的字符做顺时针旋转。
 * 3.进入加密运算的第2步:把所有下标是2倍数的字符做逆时针旋转。
 * 4.进入加密运算的第3步:把所有下标是3倍数的字符做顺时针旋转。
 * 5.按上面的规则，第奇数步按顺时针旋转，偶数步按逆时针旋转，一直到第len步为止。
 *
 * 比如原文是:abcde
 * 1.获得长度len = 5
 * 2.1的倍数有1、2、3、4、5，所以把这5个字符按顺时针旋转，得到eabcd。
 * 3.2的倍数有2、4，所以把这2个字符按逆时针旋转，得到ecbad。
 * 4.3的倍数有3，所以把这1个字符按顺时针旋转，得到ecbad。
 * 5.4的倍数有4，所以把这1个字符按逆时针旋转，得到ecbad。
 * 6.5的倍数有5，所以把这1个字符按顺时针旋转，得到ecbad。 最后的结果是ecbad。
 * 现在给你加密后的文章，让你还原成原来的文章。
 *
 *输入一篇加密后的文章，每行为一段。每段不超过1000个字符。 输入以文件结束(EOF)为止。
 * 输出
 * 输出解密后的文章。 每段一行。
 * 样例输入
 * ecbad
 * 样例输出
 * abcde
 *
 * @Author xuchaoxin
 * @Date 2020/12/26 20:11
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class Main {

}
