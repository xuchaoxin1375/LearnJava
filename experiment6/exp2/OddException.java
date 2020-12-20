package experiment6.exp2;
/*?定义受检异常类 OddException，表示两个数相除时，
除数为奇数时出现的异常。
该类必须定义两个构造?法:
默认构造?法和
带字符串参数的构造?法。*/
 class OddException extends Exception {
    double m,n;
    public OddException(double b,double c){
        //System.out.print(b+"/"+c+"中除数不能为奇数");
        m=b;
        n=c;
    }

    public  OddException(){
    }
    @Override
    public String getMessage() {

        return String.format("%.2f/%.2f=", m,n)+"中除数不能为奇数";
    }
}
