package experiment6.exp3;

import java.util.List;

 class SameIntegerException extends RuntimeException{
    int m;
    List<Integer> list;
    public SameIntegerException(int n,List<Integer> argList){
        m=n;
        list=argList;
    }
    /*because the getMessage function don't have any parameter ,so we need Set members to
    * generate specific information with parameters.*/
    @Override
    public String getMessage() {
        return "�������"+m+"�����������"+list+"����ͬ";//+"\n"

    }
}
