package map_and_hash;

public class ArrayAndObject {
  /*  //1     ��test1()���Ѿ����Եõ����½���: ����Ҳ�Ƕ���, ����Ķ��㸸����Object, ���Կ�������ת��
    int[] a = new int[8];
    Object obj = a; //����ĸ���Ҳ��Object,���Խ�a����ת�͵�Object
    int[] b = (int[]) obj;  //���Խ�������ת��*/
  /*  if(obj instanceof Object )//����,���ﶨ�����Ա�ĵط�,���ǳ�Ա�����ڲ�����ó��ֵĵط�:(������Ī���Ĵ���ʱҪ��������һ��);
    {  //������instanceof�ؼ��ֽ��������ж� (���� instanceof ��)
        System.out.println("obj����ʵ������int[]");
    }*/

    /*psvm��ݼ�:*/
  public static void main(String[] args) {
      //1     ��test1()���Ѿ����Եõ����½���: ����Ҳ�Ƕ���, ����Ķ��㸸����Object, ���Կ�������ת��
      int[] a = new int[8];
      Object obj = a ; //����ĸ���Ҳ��Object,���Խ�a����ת�͵�Object

      //2     ��ô������ת����?
      int[] b = (int[])obj;  //���Խ�������ת��

      //3     ��ʹ��instanceof�ؼ����ж���?
      if(obj instanceof int[]&&a instanceof  int[] ){  //������instanceof�ؼ��ֽ��������ж�
          System.out.println("obj����ʵ������int[]");
          /*Java���������һ�֡��̳С���ϵ*/

          /*���´�������ȷ�ģ�ȴ�������������ɻ�*/
          String[] s = new String[5];
          Object[] obja = s;   //����,˵��������Object[]������������String[]�Ķ���
          /*Object[]���͵����ÿ���ָ��String[]���͵�������� �����ĵ���֤���Ե�֪�������͵Ķ��㸸��һ����Object����ô���������s��ֱ�Ӹ�����˭�أ��ѵ�˵String[]�̳���Object[]����Object[]�ּ̳���Object? ������ͨ������ķ�ʽ����֤������⣺*/
          //��ôString[] ��ֱ�Ӹ�����Object[] ���� Object?;���Ǵ�ӡ���࿴һ��
          System.out.println(s.getClass().getSuperclass().getName());//���:java.lang.Object

      }
  }
}
