package experiment3.exp4;


import java.util.Arrays;
import java.util.HashSet;

public class vampire {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        printvampirenum(2);
        printvampirenum(3);

    }
    public static void printvampirenum(int faclen)
    {/*facient n. 乘数；因子
    length 长度
    fac_len*/
        /*faclen即因子的位数*/
        long[] product = new long[faclen*2];/*product(乘积/产品)*/
        long[] factor = new long[faclen*2];/*因子*/
        long[] exp = new long[faclen*2+1];
        HashSet<Long> has= new  HashSet<Long>();
        exp[0]=1L;
        for(int i=1;i<=2*faclen;++i)
            exp[i]=exp[i-1]*10L;
        for(long i = exp[faclen-1]; i <= exp[faclen] -1 ; ++i)
            for(long j= exp[faclen] -1 ; j>=i;--j)
            {
                long s = i * j;
                if(s%100 == 0)
                    continue;
                if(s<exp[2*faclen-1])
                    continue;
                for(int n=0;n!=faclen;++n)
                {
                    factor[n]=i%exp[n+1]/exp[n];
                    factor[n+faclen]=j%exp[n+1]/exp[n];
                }
                for(int n=0;n!= 2*faclen;++n)
                {
                    product[n]=s%exp[n+1]/exp[n];
                }
                Arrays.sort(product);
                Arrays.sort(factor);
                if(Arrays.equals(product, factor))
                {
                    if(has.contains(s))
                    {
                        //System.out.printf("[iterant]\t%d = %d \u00d7 %d;\n",s,i,j);//打印重复数据
                        continue;
                    }
                    has.add(s);
                    System.out.printf("%d = %d \u00d7 %d;\n",s,i,j);
                }
            }
    }

}

