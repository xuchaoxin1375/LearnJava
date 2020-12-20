package study.map;
/*java_求所有的连续(或单个字符)的子串.
求取字符串的所有子串的算法关键是确定分类标准,形成某一种划分
* 本算法是采用的分类标准是依次一个第i个字符打头,枚举所有该字符打头下的子串.
* 当然你还可以用字字符串的长度i_len作为划分的标准分类枚举*/
class GetAllSubstring{
    public static void main(String[] args){
        String str = "abbccc";
        System.out.println(str);

        System.out.println("所有子串的结果:(包括重复出现的)");
        for(int i = 0; i < str.length(); i++){
            for (int j = i+1; j<=str.length(); j++){
                System.out.println(str.substring(i,j));

            }
        }
    }
}
