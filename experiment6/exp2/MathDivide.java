package experiment6.exp2;

/* *
*this is a function class provided for divide two numbers and print the result
the class encapsulate the exception throws  which be meet on some occasions
 */
import java.text.DecimalFormat;

/*��дMathDivide�࣬ʵ�ֳ�Ա����divide(double b,double c)���������ݵĳ�����*/
class MathDivide {
    /**
     * if the denominator is a odd number,then throw an exception.
     * 
     * @param dividend
     * @param divisor
     * @throws OddException
     */
    void divide(double dividend, double divisor) throws OddException {
        /* �ܶ����쳣�������ڲ������쳣���׳�����ͨ��ifʵ�ֵ� */
        if (divisor % 2 != 0) {
            try {
                throw new OddException(dividend, divisor);
            } catch (OddException e) {
                /*
                 * this statement will invoke the method in the Odd Exception Class :the
                 * getMessage() method
                 */
                e.printStackTrace();
            }
        }
        /*
         * when there is no exception ,then do the division ,meanwhile Print the result
         */
        else
            System.out.println(String.format("%.2f/%.2f=", dividend, divisor)
                    + new DecimalFormat("0.00").format(dividend / divisor));

    }

}
