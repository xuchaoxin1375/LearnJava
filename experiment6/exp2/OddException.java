package experiment6.exp2;
/*?�����ܼ��쳣�� OddException����ʾ���������ʱ��
����Ϊ����ʱ���ֵ��쳣��
������붨����������?��:
Ĭ�Ϲ���?����
���ַ��������Ĺ���?����*/

 class OddException extends Exception {

    double m,n;

     /**
      * the OddException constructor  could according to the parameters to generate specific information.
      * @param dividend
      * @param divisor
      */
    public OddException(double dividend ,double divisor ){
        //System.out.print(b+"/"+c+"�г�������Ϊ����");
        m=dividend ;
        n=divisor ;
    }

    @Override
    public String getMessage() {

        return String.format("%.2f/%.2f=", m,n)+"�г�������Ϊ����";
    }
}
