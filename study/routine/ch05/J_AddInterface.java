package study.routine.ch05;

interface J_Interface <T extends Number>
{
    public int mb_sum(T a1, T a2, T a3);
} // 接口J_Interface结束

public class J_AddInterface  <T extends Number> implements J_Interface <T>
{
    public int mb_sum(T a1, T a2, T a3)
    {
        int b1 = a1.intValue( );
        int b2 = a2.intValue( );
        int b3 = a3.intValue( );
        return( b1 + b2 + b3 );
    } // 方法mb_sum结束

    public static void main(String args[ ])
    {
        J_AddInterface<Integer> b = new J_AddInterface<Integer>( );
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(2);
        Integer a3 = new Integer(3);
        System.out.println( b.mb_sum(a1, a2, a3) );
    } // 方法main结束
} // 类J_AddInterface结束

