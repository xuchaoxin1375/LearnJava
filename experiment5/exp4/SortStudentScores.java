package experiment5.exp4;

import java.util.*;

/*��ѧ�����뿼�Է���¼�뵽Set�У�����������ʾǰ�����ɼ�ѧԱ������Ҫ����Setʵ�֣�����Student��ʵ��Comparable�ӿڡ�*/
public class SortStudentScores {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("������ѧ���������ͳɼ�,������Ϊ�����ǽ�������");
        String name;
        int score;
        int i = 1;
        /*Student tmp = new Student();��������Ļ�,�޸�tmp��Ӱ�쵽set�еĶ���*/
        while (true) {
            Student tmp = new Student();//������ͬ�Ķ���;
            System.out.println("�������" + i + "λѧ��������:");
            name = sc.nextLine();
            tmp.setName(name);
            System.out.println("�������" + i++ + "λѧ���ĳɼ�:(���븺��,��������)");
            score = Integer.parseInt(sc.nextLine());
            if (score < 0) break;
            tmp.setScore(score);
            /*ͨ���������ӿ��Է���,ͨ��add��ӵ�set�Ĳ���ʱ��tmp����ĵ�ַ����set,���������Ȼ��tmpʵ��(ͬһ��ʵ������ֵ���޸�,��ô���ǻ��ᵼ��set��ָ�Ķ������仯
             * ���������Ҫһ�����Ĵ�����ͬ�Ķ���ſ���.*/
            set.add(tmp);
        }
        /*
        to sort these objects,use forEach to turn the set to the list
           of course ,you can use the ArrayList<Set> method .
         */
        List<Student> list = new ArrayList<>();
        for (Student x : set) {
            list.add(x);
        }
        /*sort and print*/
        Collections.sort(list);
        System.out.println("������ĳɼ����ɳɼ������:");
        for (Student x : list) {
            System.out.println(x);
        }
        System.out.println("ǰ����ѧ��������Ϊ:");
        Iterator<Student> it = list.iterator();/*��Ҫ��newȥ���������,list�е�iterator�����᷵��һ�����ʵĵ�����,��������Ϊ����Iterator����*/
        for (int j = 0; j < 3 && it.hasNext(); j++) {
            System.out.println(it.next());
        }

    }
}

class Student implements Comparable<Student> {
    String name;
    int score;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * The Class show us the important method must be override to make the customized
     * Class's objects to be comparable
     * <p>
     * Generally,the IDEA could help you to generate the right equals() method quickly,how cool!
     * There are three exits set.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        /**
         * for the same object(completely identical):
         * operator '==' is used for comparing the pointer of the two objects.
         * of course the first statement isn't necessary,but it can accelerate at many occasions*/
        if (this == o) return true;
        /**
         * for reference types:(objects)
         * if the parameter o is null ,then return false anyway.
         * Furthermore,if the types of parameter o is not the same as the this type,we return false
         * apparently.
         * you can use if--instanceof structure getClass
         * the o==null judge is not necessary too?*/
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        /**
         *  compare every field(member variable) in the same type objects.
         */
        return score == student.score &&
                Objects.equals(name, student.name);
        /**
         * java.util.Objects @Contract(value = "null, !null -> false; !null, null -> false", pure = true)
         * public static boolean equals(@Nullable Object a,
         *                              Object b)
         * Returns true if the arguments are equal to each other and false otherwise. Consequently, if both arguments are null, true is returned. Otherwise, if the first argument is not null, equality is determined by calling the equals method of the first argument with the second argument of this method. Otherwise, false is returned.
         *
         * Params:
         * a �C an object
         * b �C an object to be compared with a for equality
         * Returns:
         * true if the arguments are equal to each other and false otherwise
         * See Also:
         * Object.equals(Object)
         */
    }

    /**
     * the hashCode() is necessary ,too.
     * With the help of Objects java Class ,we can easily implement the specific hashCode method .
     * The detail statement is : return Objects.hash(param1,param2);
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, score);//ע����.hash������hashCode
    }

    /**
     * java.util.Objects public static int hash(@Nullable Object... values)
     * Generates a hash code for a sequence of input values. The hash code is generated as if all the input values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]).
     * <p>
     * This method is useful for implementing Object.hashCode() on objects containing multiple fields.
     * For example, if an object that has three fields, x, y, and z, one could write:
     *
     * @Override public int hashCode() {
     * return Objects.hash(x, y, z);
     * }
     */

    /*
     * comparable implement approaches --one: */
    @Override
    public int compareTo(Student o) {
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return name + "--->" + score;
    }
}