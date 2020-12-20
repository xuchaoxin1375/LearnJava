package experiment6.exp2;

import java.text.DecimalFormat;

/*编写MathDivide类，实现成员方法divide(double b,double c)，两个数据的除法。*/
 class MathDivide {
    void divide(double b,double c) throws OddException{
        if(c%2!=0){
            try {
                throw new OddException(b,c);
            } catch (OddException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println(String.format("%.2f/%.2f=", b,c)+new DecimalFormat("0.00").format(b/c ));

    }

}
