package experiment11.exp3;
/*������ɣ�a,b,c,d�����ɵ����С������ַ��������ַ������ȹ̶�Ϊ4��

    �����ַ����Ǹ��ַ�����˳�����뵹����һ����Ʃ�磺aaaa����һ������������Ϊ˳����aaaa������Ҳ��aaaa��
    abbaҲ�ǻ���������Ϊ˳����abba������Ҳ��abba��
�������������Ϊ4�����л����ַ�����

4^4��256.
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
