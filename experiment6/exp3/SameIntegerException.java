package experiment6.exp3;

import java.util.List;

 class SameIntegerException extends RuntimeException{
    int m;
    List<Integer> list;
    public SameIntegerException(int n,List<Integer> argList){
        m=n;
        list=argList;
    }
    @Override
    public String getMessage() {
        return "输入的数"+m+"和已输入的数"+list+"有相同";//+"\n"

    }
}
