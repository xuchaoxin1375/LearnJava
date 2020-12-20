    package experiment11.exp4;/*
    */

    import java.util.*;

    /**
     * 实现一个摸奖程序，
     * 在控制台输入 任意一个正数字（整数）， 按回车出现一个奖品，
     * 输入0退出程序。
     * 假设程序中存储有500个奖品，每个奖品都有2件，
     * 每次抽奖只能抽一次，取走1件奖品，奖品抽完后就不再出现。
     * <p>
     * 请编写代码实现。
     * 要求：
     * 1）输入1000个数字，奖品全部抽完；
     * 2）单词从｛a,b,c,d,e,f….,z｝中随机产生，
     * 每个奖品名称包含10个字母，奖品名称不重复。
     */

    public class Lottery {
        public static void main(String[] args) {
            //存储随机数
            int[] intArray=new int[1001];
            //存储生成的奖品
            Map<String, Integer> map = new HashMap<>();
            //用list有序化。
            // List<Map<String,Integer>> list =new ArrayList<>();
            List<Tuple> list = new ArrayList<>();
            /**统计奖品种类数目*/
            int count = 0;
            for (int i = 0; count < 500; i++) {
                String name = generateNames();
                if (map.containsKey(name)) {
                    continue;
                } else {
                    map.put(name, 2);
                    // System.out.println(name);
                }
                count++;//不要忘记！！
            }//endFor
    /**java.util.ConcurrentModificationException
     * 注意迭代器中不能修改*/
            /*将map中的键值对搬到list中*/
            for (String name : map.keySet()) {
                list.add(new Tuple(name, map.get(name)));
            }
            //System.out.println(map);监视一下。
            //得到随机数组。
            generateTestData(intArray);
            intArray[1000]=0;//在1001次个必须是结束指令0（当然你可以通过控制随机数从1开始1去取。
            //表示当前剩余的奖品数。
            int totalPrizeNumber=list.size()*2;
            //模拟抽奖。
            //读入数字(或用随机数组模拟输入）
    //        Scanner scanner = new Scanner(System.in);
            System.out.println("任意一个正数字（整数）， 按回车出现一个奖品，输入0退出程序。");
    //        int number = scanner.nextInt();
                //int number = Integer.parseInt(scanner.nextLine());
            int number,i=0;
            while (true) {
                number=intArray[i++];
                //打印出来，以便于模拟输入（数字）
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

                System.out.println("当前剩余"+(--totalPrizeNumber)+"个奖品（"+list.size()+"种不同中类的奖品）"+"任意一个正数字（整数）， 按回车出现一个奖品，输入0退出程序。");
                //number = Integer.parseInt(scanner.nextLine());
                 //number = scanner.nextInt();

            }
        }//endMain

        //generateNames()
        static String generateNames() {
            //生成奖品(名)
            char[] prizeName = new char[10];
            int countChar = 0;
            for (int i = 0; countChar < 10; i++) {
                double randomNumber = Math.random();
                /*int numberBetween1_100 = (int) (100 * randomNumber + 23);
                if (numberBetween1_100 >= 97 && numberBetween1_100 <= 122) {
                    prizeName[countChar++] = (char) (numberBetween1_100);
                }*/
                int numberBetween1_100 = (int) (97+ 26*randomNumber );//生成指定范围[a,b]内的随机数整数的技巧
                if (numberBetween1_100 >= 97 && numberBetween1_100 <= 122) {
                    prizeName[countChar++] = (char) (numberBetween1_100);
                }
            }//endFor
            return String.valueOf(prizeName);
        }
        static public void generateTestData(int[] intArray_){
            //int [] intArray=new int[1000];
            for (int i = 0; i < 1000; i++) {//保留一个
                intArray_[i]=(int)(1+Math.random()*1000);//这虽然无法去重，但可以保障不为0
            }
        }
    }//endClassLottery

