    package experiment11.exp4;/*
    */

    import java.util.*;

    /**
     * ʵ��һ����������
     * �ڿ���̨���� ����һ�������֣��������� ���س�����һ����Ʒ��
     * ����0�˳�����
     * ��������д洢��500����Ʒ��ÿ����Ʒ����2����
     * ÿ�γ齱ֻ�ܳ�һ�Σ�ȡ��1����Ʒ����Ʒ�����Ͳ��ٳ��֡�
     * <p>
     * ���д����ʵ�֡�
     * Ҫ��
     * 1������1000�����֣���Ʒȫ�����ꣻ
     * 2�����ʴӣ�a,b,c,d,e,f��.,z�������������
     * ÿ����Ʒ���ư���10����ĸ����Ʒ���Ʋ��ظ���
     */

    public class Lottery {
        public static void main(String[] args) {
            //�洢�����
            int[] intArray=new int[1001];
            //�洢���ɵĽ�Ʒ
            Map<String, Integer> map = new HashMap<>();
            //��list���򻯡�
            // List<Map<String,Integer>> list =new ArrayList<>();
            List<Tuple> list = new ArrayList<>();
            /**ͳ�ƽ�Ʒ������Ŀ*/
            int count = 0;
            for (int i = 0; count < 500; i++) {
                String name = generateNames();
                if (map.containsKey(name)) {
                    continue;
                } else {
                    map.put(name, 2);
                    // System.out.println(name);
                }
                count++;//��Ҫ���ǣ���
            }//endFor
    /**java.util.ConcurrentModificationException
     * ע��������в����޸�*/
            /*��map�еļ�ֵ�԰ᵽlist��*/
            for (String name : map.keySet()) {
                list.add(new Tuple(name, map.get(name)));
            }
            //System.out.println(map);����һ�¡�
            //�õ�������顣
            generateTestData(intArray);
            intArray[1000]=0;//��1001�θ������ǽ���ָ��0����Ȼ�����ͨ�������������1��ʼ1ȥȡ��
            //��ʾ��ǰʣ��Ľ�Ʒ����
            int totalPrizeNumber=list.size()*2;
            //ģ��齱��
            //��������(�����������ģ�����룩
    //        Scanner scanner = new Scanner(System.in);
            System.out.println("����һ�������֣��������� ���س�����һ����Ʒ������0�˳�����");
    //        int number = scanner.nextInt();
                //int number = Integer.parseInt(scanner.nextLine());
            int number,i=0;
            while (true) {
                number=intArray[i++];
                //��ӡ�������Ա���ģ�����루���֣�
                System.out.println(number);
                if (number == 0) {
                    break;
                } else {
                    String name;
                    Tuple tuple=list.get((int)(Math.random()*list.size()));
                    System.out.println(name=tuple.getName());
                    tuple.setNumber(tuple.getNumber()-1);

                    if(tuple.getNumber()==0){
                        list.remove(tuple);
                    }
                }

                System.out.println("��ǰʣ��"+(--totalPrizeNumber)+"����Ʒ��"+list.size()+"�ֲ�ͬ����Ľ�Ʒ��"+"����һ�������֣��������� ���س�����һ����Ʒ������0�˳�����");
                //number = Integer.parseInt(scanner.nextLine());
                 //number = scanner.nextInt();

            }
        }//endMain

        //generateNames()
        static String generateNames() {
            //���ɽ�Ʒ(��)
            char[] prizeName = new char[10];
            int countChar = 0;
            for (int i = 0; countChar < 10; i++) {
                double randomNumber = Math.random();
                /*int numberBetween1_100 = (int) (100 * randomNumber + 23);
                if (numberBetween1_100 >= 97 && numberBetween1_100 <= 122) {
                    prizeName[countChar++] = (char) (numberBetween1_100);
                }*/
                int numberBetween1_100 = (int) (97+ 26*randomNumber );//����ָ����Χ[a,b]�ڵ�����������ļ���
                if (numberBetween1_100 >= 97 && numberBetween1_100 <= 122) {
                    prizeName[countChar++] = (char) (numberBetween1_100);
                }
            }//endFor
            return String.valueOf(prizeName);
        }
        static public void generateTestData(int[] intArray_){
            //int [] intArray=new int[1000];
            for (int i = 0; i < 1000; i++) {//����һ��
                intArray_[i]=(int)(1+Math.random()*1000);//����Ȼ�޷�ȥ�أ������Ա��ϲ�Ϊ0
            }
        }
    }//endClassLottery

