package experiment6.exp2;
/*?�����ܼ��쳣�� OddException����ʾ���������ʱ��
����Ϊ����ʱ���ֵ��쳣��
������붨����������?��:
Ĭ�Ϲ���?����
���ַ��������Ĺ���?����*/
 class OddException extends Exception {
    double m,n;
    public OddException(double b,double c){
        //System.out.print(b+"/"+c+"�г�������Ϊ����");
        m=b;
        n=c;
    }

    public  OddException(){
    }
    @Override
    public String getMessage() {

        return String.format("%.2f/%.2f=", m,n)+"�г�������Ϊ����";
    }
}
