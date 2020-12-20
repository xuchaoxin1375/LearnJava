package experiment11.exp3;
/*编程求由｛a,b,c,d｝构成的所有“回文字符串”，字符串长度固定为4。

    回文字符串是该字符串数顺着来与倒着来一样，譬如：aaaa就是一个回文数，因为顺着是aaaa，倒着也是aaaa；
    abba也是回文数，因为顺着是abba，倒着也是abba。
请输出上述长度为4的所有回文字符串。

4^4种256.
*/
public class Palindrome {
    public static void main(String[] args) {
        char [] chars={'a','b','c','d'};
        char [] charsTmp=new char[4];
        //StringBuffer stringBuffer= new StringBuffer();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        charsTmp[0]=chars[i];
                        charsTmp[1]=chars[j];
                        charsTmp[2]=chars[k];
                        charsTmp[3]=chars[l];
                        if(charsTmp[0]==charsTmp[3]&&charsTmp[1]==charsTmp[2]){
                            System.out.println(charsTmp);
                        }
                    }
                }
            }
        }
    }
}
