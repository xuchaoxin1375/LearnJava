package experiment5.exp4;

import java.util.*;

/*把学生名与考试分数录入到Set中，并按分数显示前三名成绩学员的名字要求用Set实现，定义Student类实现Comparable接口。*/
public class SortStudentScores {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的姓名和成绩,当输入为负数是结束输入");
        String name;
        int score;
        int i = 1;
        /*Student tmp = new Student();放在外面的话,修改tmp会影响到set中的对象*/
        while (true) {
            Student tmp = new Student();//创建不同的对象;
            System.out.println("请输入第" + i + "位学生的姓名:");
            name = sc.nextLine();
            tmp.setName(name);
            System.out.println("请输入第" + i++ + "位学生的成绩:(输入负数,结束输入)");
            score = Integer.parseInt(sc.nextLine());
            if (score < 0) break;
            tmp.setScore(score);
            /*通过变量监视可以发现,通过add添加到set的操作时将tmp对象的地址存入set,如果这是任然在tmp实例(同一个实例上做值的修改,那么还是还会导致set所指的对象发生变化
             * 因此我们需要一个个的创建不同的对象才可以.*/
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
        System.out.println("您输入的成绩生成成绩单结果:");
        for (Student x : list) {
            System.out.println(x);
        }
        System.out.println("前三名学生的姓名为:");
        Iterator<Student> it = list.iterator();/*不要用new去处理迭代器,list中的iterator方法会返回一个合适的迭代器,而不是人为创建Iterator对象*/
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
         * a – an object
         * b – an object to be compared with a for equality
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
        return Objects.hash(name, score);//注意是.hash而不是hashCode
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