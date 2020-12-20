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
            /*通过变量监视可以发现,通过add添加到set的操作时讲tmp对象的地址存入set,如果这是任然在tmp实例(同一个实例上做值的修改,那么还是还会导致set所指的对象发生变化
             * 因此我们需要一个个的创建不同的对象才可以.*/
            set.add(tmp);
        }
        List<Student> list = new ArrayList<>();
        for (Student x : set) {
            list.add(x);
        }
        Collections.sort(list);
        System.out.println("您输入的成绩生成成绩单结果:");
        for(Student x:list){
            System.out.println(x);
        }
        System.out.println("前三名学生的姓名为:");
        Iterator<Student> it=list.iterator();/*不要用new去处理迭代器,list中的iterator方法会返回一个合适的迭代器,而不是人为创建Iterator对象*/
        for(int j = 0;j<3&&it.hasNext();j++){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);//注意是.hash而不是hashCode
    }


    @Override
    public int compareTo(Student o) {
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return name + "--->" + score;
    }
}