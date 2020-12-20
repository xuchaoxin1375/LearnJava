package study.routine.ch05;

// J_Add.java; 开发者: 雍俊海
//     泛型例程
public class J_Add <T>

{

    public String mb_sum(T a1, T a2, T a3)

    {

        return(a1.toString( ) + a2.toString( ) + a3.toString( ));
    } // 方法mb_sum结束
    public static void main(String args[ ])

    {

        J_Add<Integer> b = new J_Add<Integer>( );
        Integer a1 = 1;
        Integer a2 = 2;
        Integer a3 = 3;
        System.out.println( b.mb_sum(a1, a2, a3) );
    } // 方法main结束
} // 类J_Add结束
