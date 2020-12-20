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
        List<Student> list = new ArrayList<>();
        for (Student x : set) {
            list.add(x);
        }
        Collections.sort(list);
        System.out.println("������ĳɼ����ɳɼ������:");
        for(Student x:list){
            System.out.println(x);
        }
        System.out.println("ǰ����ѧ��������Ϊ:");
        Iterator<Student> it=list.iterator();/*��Ҫ��newȥ���������,list�е�iterator�����᷵��һ�����ʵĵ�����,��������Ϊ����Iterator����*/
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
        return Objects.hash(name, score);//ע����.hash������hashCode
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