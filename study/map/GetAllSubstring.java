package study.map;
/*java_�����е�����(�򵥸��ַ�)���Ӵ�.
��ȡ�ַ����������Ӵ����㷨�ؼ���ȷ�������׼,�γ�ĳһ�ֻ���
* ���㷨�ǲ��õķ����׼������һ����i���ַ���ͷ,ö�����и��ַ���ͷ�µ��Ӵ�.
* ��Ȼ�㻹���������ַ����ĳ���i_len��Ϊ���ֵı�׼����ö��*/
class GetAllSubstring{
    public static void main(String[] args){
        String str = "abbccc";
        System.out.println(str);

        System.out.println("�����Ӵ��Ľ��:(�����ظ����ֵ�)");
        for(int i = 0; i < str.length(); i++){
            for (int j = i+1; j<=str.length(); j++){
                System.out.println(str.substring(i,j));

            }
        }
    }
}
